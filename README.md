# SpringBoot-Project-AIMaker
스프링부트 + JPA_AIMaker

## 🖥 프로젝트 소개
> **당신의 이상형을 그려보세요: AI 이상형 제조기**

미혼남녀를 대상으로 진행한 설문조사에서 확고한 이상형이 있다고 답한 비율은 약 70%, 이상형을 결정 짓는 요소로 가장 중요한 요소로 미혼남녀 모두 "외모"를 뽑았습니다. 하지만 확고한 이상형이 있지만 현재 그 이상형과 만나고 있다고 답한 비율은 30%를 넘지 못하고 있습니다.

AI 이상형 제조기는 사람들의 외모 이상형을 이미지화 하는 것을 돕고 설문을 통해 자신의 이상형을 파악할 수 있는 기능을 제공합니다. 더 나아가 친구들에게 자신의 이상형을 공유하고 참여를 유도하여 재미 요소가 가미된 프로젝트를 선보입니다. 프로젝트의 기능을 다음과 같습니다.

1. 이상형 설문을 통한 이미지 화
2. 이상형 타입(동물상) 랭킹
3. 이상형 갤러리
4. 이상형 타입(동물상) 검색
5. URL로 이상형 공유


## 목차

## 📆 개발 기간
* 24.02.19일 ~ 24.04.04일

## 🙎 멤버 구성
### FE
* 임소현 : 설문조사 form UI 제작, 설문조사 기능 구현
* 정승원 : 결과  페이지 구현, 갤러리 UI/기능 구현,이상형 월드컵 UI/기능 구현

### BE
* 김예림 : 이미지 결과 산출, GPT api 연결
* 이윤지 : 이미지 설문조사 리스트 기능, S3 연결
* 이지은 : 이상형 갤러리, 이상형 월드컵
* 정여민 : 이상형 랭킹, 이상형 공유 기능

### INFRA
* 정여민 : AWS EC2, Docker, Jenkins 를 사용한 CI/CD 구축


## ⚙ 개발 환경
* Java 17
* JDK 17.0.9
* IDE : intelliJ 2023.3.2
* Framework : SpringBoot(3.2.2)
* ORM : JPA
* DB : MariaDB v.10
* 웹서버 : Apache Tomcat


## 🎁 필수 조건
* Gradle : groovy
* 사용한 dependency
    * lombok
    * Hibernate
    * MySQL
    * Spring Web
    * Spring Data JPA
    * JSON


## 서비스 아키텍처

![기술_스택](https://i.imgur.com/qjcpBnn.png)

## 📡 배포 가이드

    [노션 링크](https://pineapple-turret-b70.notion.site/8e81bba94bc448ad882d430e47e1c8be?pvs=4)


## 📌주요 기능 (API)

### BE
---
### 1. 이상형 설문조사 리스트 api
* GET : `/api/survey?type=""&gender=`
* type : String (custom / concept)
* gender : Integer
* 이상형 설문조사 타입 / 성별에 맞춰 리스트를 반환
```
{
    "type" : String,
    "gender" : String,
    "questions" : [
            {
                "title" : String,
                "type" : String,
                "question" : String,
                "answers" : [
                                {
                                    "id": Integer, 
                                    "value": String
                                }
                            ]
            }
    ]
}
```

### 2. 이상형 설문조사 결과 처리 api
* POST : `/api/survey?type=""&gender=`
* type : String (custom / concept)
* gender : Integer
* 이상형 설문조사 타입 / 성별에 맞춰 설문 선택 항목 post
* DB에 저장된 Id 값을 반환
```
"idealId" : Long
```

### 3. 설문조사 결과 (이미지, 동물상) api
* GET : `/api/result/{idealId}`
* idealId : Long
* 설문을 토대로 생성된 이상형 이미지와 동물상 분류 결과를 반환
```
{
   "idealURL" : String,
   "animalType" : String
}
```

### 4. 동물상 랭킹 api
* GET : `/api/ranking`
* 이상형 설문을 토대로 분류된 동물상 랭킹 반환
```
{
   "animalTypeRanking" : [ 
            {
                "animalType" : String,
                "animalImage" : String,
                "chooseNum" : Integer
            }
       ]
}
```

### 5. 갤러리 확인 api
* GET : `/api/gallery`
* 이상형 갤러리 리스트 확인 기능
```
{
   "page" : Integer,
   "end" : Boolean,
   "gallery" : [
        {
            "idealId": Long,
            "idealURL" : String,
            "animalType" : String
        }
   ]
}
```

### 6. 갤러리 동물상 검색 api
* GET : `/api/gallery/search/{animal-type}`
* animal-type : String
* 이상형 갤러리 동물상 검색 기능
```
{
   "page" : Integer,
   "end" : Boolean,
   "gallery" : [
        {
            "idealId": Long,
            "idealURL" : String,
            "animalType" : String,
            "genderId" : Integer
        }
    ]
}
```

### 7. 갤러리 성별 검색 api
* GET : `/api/gallery/search/{gender}`
* gender : Integer
* 이상형 갤러리 성별 검색 기능
```
{
   "page" : Integer,
   "end" : Boolean,
   "gallery" : [
        {
            "idealId": Long,
            "idealURL" : String,
            "animalType" : String,
            "genderId" : Integer
        }
    ]
}
```

### 8. 갤러리 상세 api
* GET : `/api/gallery/{ideal_id}`
* ideal_id : Long
* 이상형 갤러리 상세 보기 기능
```
{
   "idealURL" : String,
   "idealRank" : Integer,
   "createdAt" : Date,
   "animalType" : String
}
```

### 9. 이상형 월드컵 api
* GET : `/api/worldcup`
* 이상형 월드컵 기능
```
{
   "idealId" : Long,
   "idealURL" : String,
   "animalType" : String,
   "genderId" : Integer
}
```

### 10. 이상형 공유 api
* GET : `/api/share/image/{ideal_id}`
* 이상형 이미지 공유 기능
```
{
   "idealURL" : String
}
```

### FE
---

### 첫페이지
![01_첫페이지](/uploads/13dd5600286c238f7e77bedfff045f90/01_첫페이지.png)

### 이상형 제조: 이상형 선택 페이지
![05_공통선택](/uploads/a93d5c962b973958c07d9c10bebc6252/05_공통선택.png)

### 이상형 제조: 조건 선택 페이지
![06_조건선택](/uploads/e246df68cca171e5ce12ff2e6f4d50a3/06_조건선택.png)
![07_조건선택2](/uploads/97a60f397c0071b7474e99dbc63671dd/07_조건선택2.png)
![08_조건선택3](/uploads/8ef40210d7b059eebb8094e7450fa68d/08_조건선택3.png)

### 이상형 제조: 결과
![10_이상형결과](/uploads/1c7d8ccd51704aeb5f3d9d51281b110d/10_이상형결과.PNG)

### 이상형 월드컵
![12_이상형월드컵2](/uploads/16b7809697c6916bb9742a83b8cfbcdc/12_이상형월드컵2.png)
![14_이상형월드컵4](/uploads/29a9dde856136c4ec8abe845b3190afb/14_이상형월드컵4.png)

### 이상형 갤러리
![15_이상형갤러리](/uploads/3b4ab2991d08cacca4c00e74fdef328a/15_이상형갤러리.png)



## 프로젝트 디렉터리 구조
### BackEnd

```
IdealMaker
├─ .gitignore
├─ Dockerfile
├─ gradle
│  └─ wrapper
│     ├─ gradle-wrapper.jar
│     └─ gradle-wrapper.properties
├─ gradlew
├─ gradlew.bat
└─ src
   ├─ main
   │  ├─ java
   │  │  └─ com
   │  │     └─ ideal
   │  │        └─ idealmaker
   │  │           ├─ component
   │  │           │  ├─ controller
   │  │           │  ├─ data
   │  │           │  ├─ domain
   │  │           │  │  ├─ Age.java
   │  │           │  │  ├─ Background.java
   │  │           │  │  ├─ ClothStyle.java
   │  │           │  │  ├─ Concept.java
   │  │           │  │  ├─ EyeStyle.java
   │  │           │  │  ├─ Face.java
   │  │           │  │  ├─ Gender.java
   │  │           │  │  ├─ HairLength.java
   │  │           │  │  ├─ HairStyle.java
   │  │           │  │  ├─ MakeUp.java
   │  │           │  │  └─ SkinColor.java
   │  │           │  ├─ repository
   │  │           │  └─ service
   │  │           ├─ config
   │  │           │  └─ WebConfig.java
   │  │           ├─ Dalle
   │  │           │  ├─ config
   │  │           │  │  └─ OpenAiConfig.java
   │  │           │  ├─ controller
   │  │           │  │  └─ DalleController.java
   │  │           │  ├─ domain
   │  │           │  │  ├─ DalleRequest.java
   │  │           │  │  ├─ DalleResponse.java
   │  │           │  │  └─ Datum.java
   │  │           │  ├─ dto
   │  │           │  │  ├─ ConceptDto.java
   │  │           │  │  ├─ CustomManDto.java
   │  │           │  │  └─ CustomWomanDto.java
   │  │           │  ├─ service
   │  │           │  │  ├─ DalleService.java
   │  │           │  │  └─ DalleServiceImpl.java
   │  │           │  └─ util
   │  │           │     ├─ ConceptMapper.java
   │  │           │     ├─ CustomManMapper.java
   │  │           │     ├─ CustomWomanMapper.java
   │  │           │     └─ IdealMapper.java
   │  │           ├─ exception
   │  │           │  ├─ ExceptionMessage.java
   │  │           │  ├─ IllegalExtensionException.java
   │  │           │  └─ IllegalTypeException.java
   │  │           ├─ file
   │  │           │  ├─ config
   │  │           │  │  └─ S3Config.java
   │  │           │  ├─ dto
   │  │           │  │  └─ FileInfoDto.java
   │  │           │  └─ service
   │  │           │     ├─ FileS3UploadService.java
   │  │           │     └─ FileS3UploadServiceImpl.java
   │  │           ├─ gallery
   │  │           │  ├─ controller
   │  │           │  │  └─ ImageController.java
   │  │           │  ├─ dto
   │  │           │  │  └─ ImageDTO.java
   │  │           │  ├─ repository
   │  │           │  │  └─ ImageRepository.java
   │  │           │  ├─ service
   │  │           │  │  ├─ ImageService.java
   │  │           │  │  └─ ImageServiceImpl.java
   │  │           │  └─ util
   │  │           │     └─ ImageMapper.java
   │  │           ├─ ideal
   │  │           │  ├─ controller
   │  │           │  ├─ data
   │  │           │  ├─ domain
   │  │           │  │  ├─ AnimalType.java
   │  │           │  │  ├─ Ideal.java
   │  │           │  │  └─ IdealCharacter.java
   │  │           │  ├─ repository
   │  │           │  │  ├─ AnimalTypeRepository.java
   │  │           │  │  ├─ IdealCharacterRepository.java
   │  │           │  │  └─ IdealRepository.java
   │  │           │  └─ service
   │  │           ├─ IdealMakerApplication.java
   │  │           ├─ ranking
   │  │           │  ├─ controller
   │  │           │  │  └─ RankingController.java
   │  │           │  ├─ data
   │  │           │  │  └─ RankingResponseDto.java
   │  │           │  ├─ repository
   │  │           │  │  └─ RankingRepository.java
   │  │           │  └─ service
   │  │           │     └─ RankingService.java
   │  │           ├─ share
   │  │           │  ├─ controller
   │  │           │  │  └─ ShareImageController.java
   │  │           │  ├─ data
   │  │           │  │  └─ ShareImageDto.java
   │  │           │  ├─ repository
   │  │           │  │  └─ ShareImageRepository.java
   │  │           │  └─ service
   │  │           │     └─ ShareImageService.java
   │  │           └─ survey
   │  │              ├─ controller
   │  │              │  └─ SurveyController.java
   │  │              ├─ dto
   │  │              │  ├─ SelectDto.java
   │  │              │  ├─ SurveyDto.java
   │  │              │  ├─ SurveyListDto.java
   │  │              │  └─ SurveyResultDto.java
   │  │              ├─ mapper
   │  │              │  └─ SurveyMapper.java
   │  │              ├─ repository
   │  │              │  ├─ AgeRepository.java
   │  │              │  ├─ BackgroundRepository.java
   │  │              │  ├─ ClothStyleRepository.java
   │  │              │  ├─ ConceptRepository.java
   │  │              │  ├─ EyeStyleRepository.java
   │  │              │  ├─ FaceRepository.java
   │  │              │  ├─ GenderRepository.java
   │  │              │  ├─ HairLengthRepository.java
   │  │              │  ├─ HairStyleRepository.java
   │  │              │  ├─ MakeUpRepository.java
   │  │              │  └─ SkinColorRepository.java
   │  │              └─ service
   │  │                 ├─ SurveyService.java
   │  │                 └─ SurveyServiceImpl.java
   │  └─ resources
   │     ├─ application.yaml
   │     ├─ static
   │     └─ templates
   └─ test
      └─ java
         └─ com
            └─ ideal
               └─ idealmaker
                  └─ IdealMakerApplicationTests.java

```


### FrontEnd
```
FrontEnd
├─ .eslintrc.cjs
├─ .gitignore
├─ dist
│  ├─ assets
│  │  ├─ index-B1D3t4of.css
│  │  └─ index-BuBuXlXh.js
│  ├─ index.html
│  ├─ MainLogo.svg
│  └─ vite.svg
├─ Dockerfile
├─ index.html
├─ nginx.conf
├─ package-lock.json
├─ package.json
├─ pnpm-lock.yaml
├─ postcss.config.js
├─ public
│  └─ MainLogo.svg
├─ ReadMe.md
├─ src
│  ├─ apis
│  │  └─ ResultAPI.tsx
│  ├─ assets
│  │  ├─ icons
│  │  │  ├─ LoadingCircle.tsx
│  │  │  ├─ LoadingLogo.tsx
│  │  │  ├─ MainLogo.tsx
│  │  │  └─ Trophy.tsx
│  │  └─ images
│  │     ├─ cat.webp
│  │     ├─ deer.webp
│  │     ├─ dog.webp
│  │     ├─ rabbit.webp
│  │     ├─ react.svg
│  │     └─ wolf.webp
│  ├─ components
│  │  ├─ idealPick
│  │  │  └─ IdealPickDiv.tsx
│  │  ├─ loading
│  │  │  └─ Loading.tsx
│  │  └─ modals
│  │     └─ report
│  │        ├─ ReportModal.tsx
│  │        └─ styles.css
│  ├─ index.css
│  ├─ main.tsx
│  ├─ pages
│  │  ├─ form
│  │  │  ├─ IdealBasicForm.tsx
│  │  │  └─ IdealForm.tsx
│  │  ├─ idealPick
│  │  │  └─ IdealPick.tsx
│  │  ├─ invite
│  │  │  ├─ Invite.tsx
│  │  │  └─ styles.css
│  │  ├─ main
│  │  │  └─ IdealMain.tsx
│  │  └─ result
│  │     └─ IdealResult.tsx
│  ├─ routes
│  │  ├─ app
│  │  │  └─ App.tsx
│  │  └─ main
│  │     ├─ App.css
│  │     ├─ index.tsx
│  │     └─ styles.tsx
│  ├─ stores
│  │  └─ IdealPick.tsx
│  ├─ types
│  │  └─ type.d.ts
│  ├─ utils
│  │  ├─ axios
│  │  │  └─ LocalAxios.ts
│  │  ├─ idealPick
│  │  │  └─ IdealPickFunc.tsx
│  │  └─ toast
│  │     └─ Toast.tsx
│  └─ vite-env.d.ts
├─ tailwind.config.js
├─ tsconfig.json
├─ tsconfig.node.json
└─ vite.config.ts

```
