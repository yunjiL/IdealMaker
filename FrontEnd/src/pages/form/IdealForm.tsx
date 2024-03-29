import {useLocation, useNavigate} from "react-router-dom"
import {ConceptForm, ConceptFormResult, Answer, CustomMan, CustomWoman, Question} from "../../types/type"
import {useEffect, useState} from "react";
import {useForm} from "react-hook-form";
import {getFormAPI, postFormResultAPI} from "../../apis/ResultAPI";
import {Button} from "flowbite-react";
import {SketchPicker} from "react-color";

const IdealForm = () => {

    {/* 변수 선언 시작 */}
    const navigate = useNavigate();
    const location = useLocation();
    const {surveyId, genderId} = location.state;

    const [surveyList, setSurveyList] = useState<ConceptForm>({
        genderId: 0, questions: [], surveyType: ""
    });


    useEffect(() => {
        getFormAPI(surveyId, genderId).then((data) => {
            setSurveyList({...surveyList, genderId: data.genderId, questions: data.questions, surveyType: data.type})
            console.log(data.questions)
            data.questions.map((item:Question)=>{
                if(item.type==="color") watch(item.title);
                else watch(item.title+"Id");
            })
        });
    }, []);

    {/* 변수 선언 끝 */}

    const QuestionComponent = (props: { answers: Answer[] | null, title: string }) => {
        const selectedKey = props.title + "Id";

        let length = props.answers?props.answers.length:0;
        if(length>3) length = 2;
        return (
            <div className={`grid grid-cols-${length}`}>
                {
                    props.answers?.map((item) => (
                        <Button
                            {...register(selectedKey)}
                            key={item.id}
                            onClick={() => {
                                setValue(selectedKey, item.id);
                            }}
                            className={getValues(selectedKey) === item.id ?
                                "bg-lightpink rounded-3xl shadow-custom-outer px-[4%] py-[1%] mx-auto my-[3%] active:scale-90 duration-300"
                                : "bg-bluegray rounded-3xl shadow-custom-outer px-[4%] py-[1%] mx-auto my-[3%] active:scale-90 duration-300"}> {item.value} </Button>
                    ))
                }
            </div>
        );
    };



    {/* react form hook 설정 시작*/}
    const {
        watch,
        register,
        handleSubmit: onSubmit,
        setValue,
        getValues,
    } = useForm<ConceptFormResult|CustomMan|CustomWoman>({
        mode: "onChange",
        defaultValues: {
            genderId: (Number)(genderId),
        },
    });


    const handleRegistration = (data:ConceptFormResult|CustomMan|CustomWoman) => {
        //axios 통신 넣기
        postFormResultAPI(data, surveyId).then((response)=>{
            console.log(response)
        });
        //link넣기
        navigate("/result");
    };

    {/* react form hook 설정 끝*/}

    return (<div className="flex">
            <form onSubmit={onSubmit(handleRegistration)} className="w-full">
                {surveyList?.questions?.map(survey => {
                        return <div key={survey.title}>
                            <p className="font-bold text-xl my-[5%] text-center"> {survey.question} </p>
                            {survey.answers == null ?
                                <SketchPicker
                                    className="mx-auto"
                                    color={getValues(survey.title)}
                                    onChangeComplete={color=>{
                                    const k =survey.title;
                                    setValue(k,color.hex);

                                    document.body.style.background = color.hex;
                                }}/>
                                : <div>
                                <QuestionComponent answers={survey.answers} title={survey.title}/>
                            </div>
                            }

                        </div>
                    }
                )}

                <div className="flex">
                    <input type="submit" value="제출" className="text-center bg-lightpink rounded-3xl shadow-custom-outer px-[10%] py-[1%] mx-auto my-[3%] active:scale-90 duration-300"/>
                </div>
            </form>


        </div>
    )
}

export default IdealForm