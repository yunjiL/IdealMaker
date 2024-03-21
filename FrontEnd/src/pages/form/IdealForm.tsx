import { useLocation, useNavigate } from "react-router-dom"
import { ConceptForm, ConceptFormResult } from "../../types/type"
import { useEffect, useState } from "react";
import { useForm } from "react-hook-form";
import { Button } from "flowbite-react";

import { getFormAPI } from "../../apis/ResultAPI";

const IdealForm = () => {
  const navigate = useNavigate();
  const location = useLocation();
  const {surveyId, genderId} = location.state;


  const [surveyList, setSurveyList] = useState<ConceptForm>();
  const [selected, setSelected] = useState<string[]>([genderId, "-1","-1","-1","-1","-1","-1"]);


  useEffect(()=>{
    getFormAPI(surveyId,genderId).then((data)=>{
      console.log(data)
      setSurveyList(data)
    });
  },[]);



  const {
      handleSubmit:onSubmit,
      setValue,
    } = useForm<ConceptFormResult>({
      mode:"onSubmit",
      defaultValues:{
          genderId:(Number)(genderId),
          pupilColor: "#000000",
      },
    });


  const handleRegistration=(
      // data:ConceptFormResult
  )=>{
      //axios 통신 넣기

      // axios.create({
      //   baseURL: "https://j10a302.p.ssafy.io/api",
      // }).post("/survey/concept", JSON.stringify(data),{
      //   headers:{
      //     "Content-Type": `application/json;charset=UTF-8`,
      //     "Accept": "application/json",
      //     "Access-Control-Allow-Origin": `http://localhost:3000`,
      //     'Access-Control-Allow-Credentials':"true",
      //   }
      // }).then((res)=>{
      //   console.log(res);
      // })

      //link넣기

      navigate("/result");
  };

return (
  <div className="flex">
      <form onSubmit={onSubmit(handleRegistration)} className="w-full">
      {/* 설문조사 하나 시작 */}
      <p className="font-bold text-xl my-[5%] text-center"> 나이를 선택해주세요. </p>
      {
        surveyList?.ageList?.map((item)=>
        <Button
        key={item.ageId}
        onClick={()=>{
          if(selected[1]==="-1"){
            setValue("ageId",item.ageId);
            selected[1]=item.ageId.toString()
          }else{
            setValue("ageId",-1);
            selected[1] = "-1";
          }
          setSelected([...selected]);

        }
      }   className={selected[1]===item.ageId.toString()?
        "bg-lightpink rounded-3xl shadow-custom-outer px-[4%] mx-auto my-[5%] active:scale-90 duration-300"
        :"bg-bluegray rounded-3xl shadow-custom-outer px-[4%] mx-auto my-[5%] active:scale-90 duration-300"}> {item.age} </Button>
        )
      }
      {/* 설문조사 하나 끝 */}

      {/* 설문조사 하나 시작 */}
      <p className="font-bold text-xl my-[5%] text-center"> 얼굴형을 선택해주세요. </p>
      {
        surveyList?.faceShapeList?.map((item,)=>
        <Button
        key={item.faceShapeId}
        onClick={()=>{
          if(selected[2]==="-1"){
            setValue("faceShapeId",item.faceShapeId);
            selected[2]=item.faceShapeId.toString()
          }else{
            setValue("ageId",-1);
            selected[2] = "-1";
          }
          setSelected([...selected]);
        }
      }   className={selected[2]===item.faceShapeId.toString()?
        "bg-lightpink rounded-3xl shadow-custom-outer px-[4%] mx-auto my-[5%] active:scale-90 duration-100"
        :"bg-bluegray rounded-3xl shadow-custom-outer px-[4%] mx-auto my-[5%] active:scale-90 duration-100"}> {item.faceShape} </Button>
        )
      }
      {/* 설문조사 하나 끝 */}


      {/* 설문조사 하나 시작 */}
      <p className="font-bold text-xl my-[5%] text-center"> 피부색을 선택해주세요. </p>
      {
        surveyList?.skinColorList?.map((item, )=>
        <Button
        key={item.skinColorId}
        onClick={()=>{
          if(selected[3]==="-1"){
            setValue("skinColorId",item.skinColorId);
            selected[3]=item.skinColorId.toString()
          }else{
            setValue("skinColorId",-1);
            selected[3] = "-1";
          }
          setSelected([...selected]);
        }
      }   className={selected[3] === item.skinColorId.toString()?
        "bg-lightpink rounded-3xl shadow-custom-outer px-[4%] mx-auto my-[5%] active:scale-90 duration-100"
        :"bg-bluegray rounded-3xl shadow-custom-outer px-[4%] mx-auto my-[5%] active:scale-90 duration-100"}> {item.skinColor} </Button>
        )
      }
      {/* 설문조사 하나 끝 */}

      {/* 설문조사 하나 시작 */}
      <p className="font-bold text-xl my-[5%] text-center"> 눈 색을 선택해주세요. </p>
      {
        surveyList?.eyeStyleList?.map((item)=>
        <Button
        key={item.eyeStyleId}
        onClick={()=>{
          if(selected[4]==="-1"){
            setValue("eyeStyleId",item.eyeStyleId);
            selected[4]=item.eyeStyleId.toString()
          }else{
            setValue("eyeStyleId",-1);
            selected[4] = "-1";
          }
          setSelected([...selected]);
        }
      }   className={ selected[4] === item.eyeStyleId.toString()?
        "bg-lightpink rounded-3xl shadow-custom-outer px-[4%] mx-auto my-[5%] active:scale-90 duration-100"
        :"bg-bluegray rounded-3xl shadow-custom-outer px-[4%] mx-auto my-[5%] active:scale-90 duration-100"}> {item.eyeStyle} </Button>
        )
      }
      {/* 설문조사 하나 끝 */}

      {/* 설문조사 하나 시작 */}
      <p className="font-bold text-xl my-[5%] text-center"> 컨셉을 선택해주세요. </p>
      {
        surveyList?.conceptList?.map((item)=>
        <Button
        key={item.conceptId}
        onClick={()=>{
          if(selected[5]==="-1"){
            setValue("eyeStyleId",item.conceptId);
            selected[5]=item.conceptId.toString()
          }else{
            setValue("eyeStyleId",-1);
            selected[5] = "-1";
          }
          setSelected([...selected]);

        }
      }   className={selected[5] === item.conceptId.toString()?
        "bg-lightpink rounded-3xl shadow-custom-outer px-[4%] mx-auto my-[5%] active:scale-90 duration-100"
        :"bg-bluegray rounded-3xl shadow-custom-outer px-[4%] mx-auto my-[5%] active:scale-90 duration-100"}> {item.concept} </Button>
        )
      }
      {/* 설문조사 하나 끝 */}
      <div className="flex">
        <input type="submit" value="제출" className="mx-auto text-center"/>
      </div>
      </form>


  </div>
)
}

export default IdealForm