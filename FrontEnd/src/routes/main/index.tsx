import './App.css'
import {Navigate, Route, Routes} from "react-router-dom";
import {BodySection, MainLayout} from "./styles.tsx";
import IdealMain from "../../pages/main/IdealMain.tsx";
import Loading from "../../components/loading/Loading.tsx";
import IdealResult from "../../pages/result/IdealResult.tsx";
import IdealBasicForm from '../../pages/form/IdealBasicForm.tsx';
import IdealForm from '../../pages/form/IdealForm.tsx';

function Index() {

  return (
      <MainLayout>
        <BodySection className="scrollBar">
            <Routes>
                <Route path="/" element={<IdealMain/>}/>
                <Route path="/loading" element={<Loading/>}/>
                <Route path="/result" element={<IdealResult/>}/>
                <Route path="/form" element={<IdealBasicForm/>}/>
                <Route path="/IdealForm" element={<IdealForm />}/>
                {/* 밑은 다른 주소로 접근 방지용 */}
                <Route path={"*"} element={<Navigate to="/"/>}/>
            </Routes>
        </BodySection>
      </MainLayout>
  )
}

export default Index
