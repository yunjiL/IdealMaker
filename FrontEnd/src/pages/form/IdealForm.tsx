import {useLocation, useNavigate} from "react-router-dom"
import {ConceptForm, ConceptFormResult, Answer} from "../../types/type"
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
        gender: 0, questions: [], type: ""
    });
    const [selected, setSelected] = useState<ConceptFormResult>({
        ageId: 0,
        conceptId: 0,
        eyeStyleId: 0,
        faceShapeId: 0,
        genderId: Number(genderId),
        pupilColor: "#000000",
        skinColorId: 0,
    });


    useEffect(() => {
        getFormAPI(surveyId, genderId).then((data) => {
            setSurveyList({...surveyList, gender: data.genderId, questions: data.questions, type: data.type})
        });
    }, []);

    {/* 변수 선언 끝 */}

    const QuestionComponent = (props: { answers: Answer[] | null, title: string }) => {
        const selectedKey = props.title + "Id";
        return (
            <div className="">
                {
                    props.answers?.map((item) => (
                        <Button
                            key={item.id}
                            onClick={() => {
                                const temp = selected;
                                temp[selectedKey] = item.id;
                                setSelected({...temp});
                                setValue(selectedKey,item.id);
                            }}
                            className={selected[selectedKey] === item.id ?
                                "bg-lightpink rounded-3xl shadow-custom-outer px-[4%] py-[1%] mx-auto my-[3%] active:scale-90 duration-300"
                                : "bg-bluegray rounded-3xl shadow-custom-outer px-[4%] py-[1%] mx-auto my-[3%] active:scale-90 duration-300"}> {item.value} </Button>
                    ))
                }
            </div>
        );
    };



    {/* react form hook 설정 시작*/}
    const {
        handleSubmit: onSubmit,
        setValue,
    } = useForm<ConceptFormResult>({
        mode: "onSubmit",
        defaultValues: {
            genderId: (Number)(genderId),
            ageId: 0,
            conceptId: 0,
            eyeStyleId: 0,
            faceShapeId: 0,
            pupilColor: "#000000",
            skinColorId: 0,
        },
    });


    const handleRegistration = () => {
        //axios 통신 넣기
        console.log(selected)
        postFormResultAPI(selected, surveyId).then(()=>{
            console.log("FIN")
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
                                    color={selected[survey.title]}
                                    onChangeComplete={color=>{
                                    const temp = selected;
                                    const k =survey.title;
                                    console.log(k)
                                    temp[k] = color.hex;
                                    setSelected({...temp});
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