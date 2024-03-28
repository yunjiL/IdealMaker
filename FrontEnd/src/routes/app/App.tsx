import styled from "styled-components";
import {Route, Routes} from "react-router-dom";
import Main from "../main/index.tsx";
import {QueryClient, QueryClientProvider} from '@tanstack/react-query'

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
    const queryClient = new QueryClient()
  return (
    <>
        <QueryClientProvider client={queryClient}>
        <Container>
            <Routes>
                <Route path="/*" element={<Main/>}/>
            </Routes>
        </Container>
        </QueryClientProvider>
    </>
  )
}

export default App
