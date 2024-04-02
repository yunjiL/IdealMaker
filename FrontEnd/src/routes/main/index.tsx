import './App.css'
import {Navigate, Route, Routes} from "react-router-dom";
import {BodySection, MainLayout} from "./styles.tsx";
import IdealMain from "../../pages/main/IdealMain.tsx";
import Loading from "../../components/loading/Loading.tsx";
import IdealResult from "../../pages/result/IdealResult.tsx";
import IdealBasicFormPage from '../../pages/form/IdealBasicFormPage.tsx';
import IdealForm from '../../pages/form/IdealForm.tsx';
import IdealPick from "../../pages/idealPick/IdealPick.tsx";
import Invite from "../../pages/invite/Invite.tsx";
import React from 'react';
import IdealGallery from "../../pages/gallery/IdealGallery.tsx";

function Index() {
    const validation = () => {
        return sessionStorage.getItem('validated') == 'yes'
    }

    return (
      <MainLayout>
        <BodySection className="scrollBar max-screen">
            <Routes>
                <Route path="/" element={<IdealMain/>}/>
                <Route path="/invite" element={<Invite/>}/>
                <Route path="/idealPick" element={<IdealPick/>}/>
                {validation() && (
                <React.Fragment>
                    <Route path="/loading" element={<Loading/>}/>
                    <Route path="/result" element={<IdealResult/>}/>
                    <Route path="/form" element={<IdealBasicFormPage/>}/>
                    <Route path="/IdealForm" element={<IdealForm />}/>
                    <Route path="/gallery" element={<IdealGallery/>}/>
                </React.Fragment>
                )}
                {/* 밑은 다른 주소로 접근 방지용 */}
                <Route path={"*"} element={<Navigate to="/"/>}/>
            </Routes>
        </BodySection>
      </MainLayout>
  )
}

export default Index
