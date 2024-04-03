import {useState} from "react";
import {useForm} from "react-hook-form";
import {Button} from 'flowbite-react';
import {BasicForm} from "../../types/type";
import {useNavigate} from "react-router-dom";
import AnswerButton from "../../components/forms/AnswerButton.tsx";
import QuestionHeading from "../../components/forms/QuestionHeading.tsx";

const Q_TYPE = {
    SURVEY: "surveyId",
    GENDER: "genderId",
} as const;
type Q_TYPE = typeof Q_TYPE[keyof typeof Q_TYPE];

const BasicFormData = [
    {
        id: 0,
        formType: Q_TYPE.SURVEY,
        question: "어떤 모드로 하고 싶나용?",
        answer: [
            {id: "concept", meaning: "나는 쉽고 빠르게 이상형을 보고싶구나..."},
            {id: "custom", meaning: "나는 완벽한 이상형을 보고싶구나..."},
        ]
    },
    {
        id: 1,
        formType: Q_TYPE.GENDER,
        question: "어떤 성별의 이상형을 보고 싶나용?",
        answer: [
            {id: "1", meaning: "난...남자가 보고싶구나..."},
            {id: "2", meaning: "난...여자가 보고싶구나..."},
        ]
    }
];


const IdealBasicFormPage = () => {
    const navigate = useNavigate();

    const [nowIdx, setNowIdx] = useState(0);
    const [isNotChoice, setIsNotChoice] = useState(false);

    const [clickedValue, setClickedValue] = useState("");

    const {
        handleSubmit: onSubmit,
        setValue,
        getValues
    } = useForm<BasicForm>({
        mode: "onSubmit",
        defaultValues: {
            surveyId: ""
            , genderId: ""
        },
    });
    const handleSubmit = (data: BasicForm) => {
        if(clickedValue==="") {
            setIsNotChoice(true);
        }else{
            navigate("/IdealForm", {state: {surveyId: data.surveyId, genderId: data.genderId}});
        }

    };
    return (
        <div className="flex">
            <form onSubmit={onSubmit(handleSubmit)} className="w-full">
                {BasicFormData[nowIdx] && (
                    <>
                        <QuestionHeading questionText={BasicFormData[nowIdx].question}/>
                        {BasicFormData[nowIdx].answer.map((item) =>
                            <AnswerButton
                                key={item.id}
                                questionText={item.meaning}
                                onClick={() => {
                                    setIsNotChoice(false);
                                    setValue(BasicFormData[nowIdx].formType, `${item.id}`)
                                    setClickedValue(item.id)
                                }}
                                style={item.id === getValues(BasicFormData[nowIdx].formType) ? `pink-button` : "gray-button"}/>
                        )}
                        {isNotChoice && (
                            <div className="font-bold text-xl my-10 text-center text-red animate-bounce">선택하고 다음 누르거라 이것들아 </div>
                        )
                        }
                    </>
                )
                }
                {
                    <div className="flex">
                        {
                            nowIdx < BasicFormData.length - 1 ?
                                <Button onClick={() =>{
                                    if(clickedValue===""){
                                        setIsNotChoice(true);
                                    }else{
                                        setNowIdx(nowIdx+1);
                                        setClickedValue("");
                                    }
                                } } className="mx-auto text-center">다음</Button>
                                : <input type="submit" value="제출" className="mx-auto text-center"/>
                        }
                    </div>
                }
            </form>


        </div>
    )
}

export default IdealBasicFormPage