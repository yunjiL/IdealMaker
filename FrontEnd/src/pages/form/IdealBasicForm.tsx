import { useState } from "react";
import {useForm} from  "react-hook-form";
import { Button } from 'flowbite-react';
import { BasicForm } from "../../types/type";
import { useNavigate } from "react-router-dom";

const Q_TYPE = {
    SURVEY :"surveyId",
    GENDER : "genderId",
} as const;
type Q_TYPE = typeof Q_TYPE[keyof typeof Q_TYPE];

const BasicFormData=[
    {
        id:0,
        formType:Q_TYPE.SURVEY,
        question: "어떤 모드로 하고 싶나용?",
        answer:[
            {id: "concept", meaning: "나는 쉽고 빠르게 이상형을 보고 시퍼!!!"},
            {id: "custom", meaning: "나는 완벽한 내 이상형을 보고 시퍼!!!"},
        ]
    },
    {
        id:1,
        formType:Q_TYPE.GENDER,
        question: "어떤 성별의 이상형을 보고 싶나용?",
        answer:[
            {id: "1", meaning: "난...남자가 보고싶구나..."},
            {id: "2", meaning: "난...여자가 보고싶구나..."},
        ]
    }
];


const IdealBasicForm = () => {
    const navigate = useNavigate();

    const [nowIdx, setNowIdx] = useState(0);
    const [selectedIdx, setSelectedIdx] = useState("");


    const {
        handleSubmit:onSubmit,
        setValue,
      } = useForm<BasicForm>({
        mode:"onSubmit",
        defaultValues:{
            surveyId:"concept"
            , genderId:"0"
        },
      });
    const handleSubmit=(data:BasicForm)=>{
        console.log(data);
        navigate("/IdealForm", {state:{surveyId: data.surveyId, genderId:data.genderId}});
    };

  return (
    <div className="flex">
        <form onSubmit={onSubmit(handleSubmit)} className="w-full">
            {BasicFormData[nowIdx]  &&(
                <>
                <p className="font-bold text-xl my-10 text-center">{BasicFormData[nowIdx].question}</p>
                
                {BasicFormData[nowIdx].answer.map((item)=> 
                <Button 
                key={item.id}
                onClick={()=>{
                    setValue(BasicFormData[nowIdx].formType,`${item.id}`)
                    setSelectedIdx(item.id);
                }} 

            className={item.id===selectedIdx?
                "bg-lightpink rounded-3xl shadow-custom-outer px-[4%] mx-auto my-[5%] active:scale-90 duration-300" 
                :"bg-bluegray rounded-3xl shadow-custom-outer px-[4%] mx-auto my-[5%] active:scale-90 duration-300"} >{item.meaning}</Button>
                )}
                </>
            )
            }
            {
                <div className="flex">
                    {
                        nowIdx<BasicFormData.length-1? 
                        <Button onClick={()=>setNowIdx(nowIdx+1)} className="mx-auto text-center">이상형 찾으러 가기</Button>
                        : <input type="submit" value="제출" className="mx-auto text-center"/>
                    }
                </div>
            }
        </form>


    </div>
  )
}

export default IdealBasicForm