import {useLocation, useNavigate} from "react-router-dom"
import {ConceptForm, ConceptFormResult, Answer, CustomMan, CustomWoman, Question} from "../../types/type"
import {useEffect, useState} from "react";
import {useForm} from "react-hook-form";
import {getFormAPI} from "../../apis/ResultAPI";
import {Button} from "flowbite-react";
import {SketchPicker} from "react-color";
// import {useQuery} from "@tanstack/react-query";
// import Loading from "../../components/loading/Loading.tsx";
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
            data.questions.map((item:Question)=>{
                if(item.type==="color") watch(item.title);
                else watch(item.title+"Id");
            })
        });
    }, []);

    const handleRegistration = (data:ConceptFormResult|CustomMan|CustomWoman) => {
    // const{data:number, isLoading} = useQuery({queryKey:["result"], queryFn:()=>postFormResultAPI(data, surveyId)})
    // if(isLoading) return <Loading/>
    navigate("/result", {state: {idealId:data}});
    };

    const QuestionComponent = (props: { answers: Answer[] | null, title: string }) => {
        const selectedKey = props.title + "Id";

        return (
            <div className={length>3? "grid grid-cols-2": "grid grid-cols-3"}>
                {
                    props.answers?.map((item) => (
                        <Button
                            {...register(selectedKey)}
                            key={item.id}
                            onClick={() => {
                                setValue(selectedKey, item.id);
                            }}
                            className={getValues(selectedKey) === item.id ?
                                "bg-lightpink rounded-3xl shadow-custom-outer p-2 w-[55%] mx-auto my-[10%] active:scale-90 duration-300"
                                : "bg-bluegray rounded-3xl shadow-custom-outer p-2 w-[55%] mx-auto my-[10%] active:scale-90 duration-300"}> {item.value} </Button>
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


    {/* react form hook 설정 끝*/}

    return (<div className="flex">
            <form onSubmit={onSubmit(handleRegistration)} className="w-full" method="GET">
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