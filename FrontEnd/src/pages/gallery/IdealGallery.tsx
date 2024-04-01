import {useEffect, useState} from "react";
import {Button} from "./styles.tsx";
import {getGalleryAPI} from "../../apis/GalleryAPI.tsx";
import {galleryContent} from "../../types/type";

const IdealGallery = () => {
    const [selectedType, setSelectedType] = useState('')
    const [selectedGender, setSelectedGender] = useState('')
    const [gallery, setGallery] = useState<galleryContent[]>([])
    const handleType = (option:string) => {
        setSelectedType(currentType=> currentType === option ? '' : option)
    }
    const handleGender = (option:string) => {
        setSelectedGender(currentGender => currentGender === option ? '' : option)
    }

    useEffect(()=> {
       getGalleryAPI().then((data)=>{
           setGallery(data.content)
       })
    },[])
    console.log(gallery)
    return (
        <div className="mt-[5%]">
            <div className="flex justify-center mb-[5%]">
                <Button className={`${selectedType === 'wolf' ? 'bg-lightpink' : 'bg-bluegray'}`} onClick={()=>handleType('wolf')}>늑대상</Button>
                <Button className={`${selectedType === 'rabbit' ? 'bg-lightpink' : 'bg-bluegray'}`} onClick={()=>handleType('rabbit')}>토끼상</Button>
                <Button className={`${selectedType === 'deer' ? 'bg-lightpink' : 'bg-bluegray'}`} onClick={()=>handleType('deer')}>사슴상</Button>
                <Button className={`${selectedType === 'dog' ? 'bg-lightpink' : 'bg-bluegray'}`} onClick={()=>handleType('dog')}>강아지상</Button>
                <Button className={`${selectedType === 'cat' ? 'bg-lightpink' : 'bg-bluegray'}`} onClick={()=>handleType('cat')}>고양이상</Button>
            </div>
            <div className="flex justify-center mb-[5%]">
                <Button className={`${selectedGender === 'Man'? 'bg-lightpink':'bg-bluegray'}`} onClick={()=>handleGender('Man')}>남자</Button>
                <Button className={`${selectedGender === 'Woman'? 'bg-lightpink':'bg-bluegray'}`} onClick={()=>handleGender('Woman')}>여자</Button>
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