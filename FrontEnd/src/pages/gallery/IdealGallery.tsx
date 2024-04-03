import {useEffect, useState} from "react";
import {Button} from "./styles.tsx";
import {getGalleryAPI, getGalleryGenderAPI, getGalleryTypeAPI} from "../../apis/GalleryAPI.tsx";
import {galleryContent} from "../../types/type";
import {Link} from "react-router-dom";

const IdealGallery = () => {
    const [selectedType, setSelectedType] = useState('')
    const [gallery, setGallery] = useState<galleryContent[]>([])
    const handleType = (option:string) => {
        setSelectedType(currentType=> currentType === option ? '' : option)
        if(option === '') {
            getGalleryAPI().then((data)=>{setGallery(data.content)})
        } else if (option === 'Man' || option ==='Woman') {
            getGalleryGenderAPI(option).then((data)=>{setGallery(data.content)})
        } else {
            getGalleryTypeAPI(option).then((data)=>{setGallery(data.content)})
        }
    }

    useEffect(()=> {
       getGalleryAPI().then((data)=>{
           setGallery(data.content)
       })
    },[])
    return (
        <div className="mt-[5%]">
            <div className="flex justify-center mb-[5%]">
                <Link to="/" className="animate-bounce text-2xl">&gt;&gt; 홈으로 돌아가기 &lt;&lt;</Link>
            </div>
            <div className="flex justify-center mb-[5%]">
                <Button className={`${selectedType === '늑대상' ? 'bg-lightpink' : 'bg-bluegray'}`} onClick={()=>handleType('늑대상')}>늑대상</Button>
                <Button className={`${selectedType === '토끼상' ? 'bg-lightpink' : 'bg-bluegray'}`} onClick={()=>handleType('토끼상')}>토끼상</Button>
                <Button className={`${selectedType === '사슴상' ? 'bg-lightpink' : 'bg-bluegray'}`} onClick={()=>handleType('사슴상')}>사슴상</Button>
                <Button className={`${selectedType === '강아지상' ? 'bg-lightpink' : 'bg-bluegray'}`} onClick={()=>handleType('강아지상')}>강아지상</Button>
                <Button className={`${selectedType === '고양이상' ? 'bg-lightpink' : 'bg-bluegray'}`} onClick={()=>handleType('고양이상')}>고양이상</Button>
            </div>
            <div className="flex justify-center mb-[5%]">
                <Button className={`${selectedType === 'Man'? 'bg-lightpink':'bg-bluegray'}`} onClick={()=>handleType('Man')}>남자</Button>
                <Button className={`${selectedType === 'Woman'? 'bg-lightpink':'bg-bluegray'}`} onClick={()=>handleType('Woman')}>여자</Button>
            </div>
            <div className="grid grid-cols-3">
                {gallery?.map((item)=> (
                    <div key={item.idealId} className="m-3">
                        <img src={item.idealURL} alt={"galleryimage"} className="rounded-2xl"/>
                    </div>
                ))}
            </div>
        </div>
    )
}

export default IdealGallery