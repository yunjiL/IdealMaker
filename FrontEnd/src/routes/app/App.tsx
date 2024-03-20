import styled from "styled-components";
import {Route, Routes} from "react-router-dom";
import Main from "../main/index.tsx";

const Container = styled.div`
  width: 40%;
  height: 100%;
  background-color: floralwhite; 

  /* 모바일 환경에서는 너비를 100%로 */
  @media (max-width: 768px) {
    width: 100%;
  }
`;

function App() {
  return (
    <>
        <Container>
            <Routes>
                <Route path="/*" element={<Main/>}/>
            </Routes>
        </Container>
    </>
  )
}

export default App
