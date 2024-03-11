import './App.css'
import {Route, Routes} from "react-router-dom";
import Test from "../../pages/index.tsx"
import {BodySection, MainLayout} from "./styles.tsx";

function Index() {

  return (
      <MainLayout>
        <BodySection className="scrollBar">
            <Routes>
                <Route path="/" element={<Test/>}/>
            </Routes>
        </BodySection>
      </MainLayout>
  )
}

export default Index
