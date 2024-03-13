import './App.css'
import {Navigate, Route, Routes} from "react-router-dom";
import {BodySection, MainLayout} from "./styles.tsx";
import IdealMain from "../../pages/main/IdealMain.tsx";

function Index() {

  return (
      <MainLayout>
        <BodySection className="scrollBar">
            <Routes>
                <Route path="/" element={<IdealMain/>}/>

                {/* 밑은 다른 주소로 접근 방지용 */}
                <Route path={"*"} element={<Navigate to="/"/>}/>
            </Routes>
        </BodySection>
      </MainLayout>
  )
}

export default Index
