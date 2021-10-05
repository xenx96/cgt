/**
 * 여기부터는 Lib 호출 부분
 */
import React from 'react';
import ReactDOM from 'react-dom';
import {BrowserRouter, Route} from 'react-router-dom';
import reportWebVitals from './reportWebVitals';

/**
 * 여기부터는 Component Import 부분
 */
//import Header from './components/header';
import Footer from './components/footer';
import Contents from './components/contents';
import Join from './components/join';
import Board from './components/Board';
import Login from './components/login';

/**
 * 경고! CSS부분은 전체 페이지의 공통 CSS 부분은
 * Header나 Footer에 할당하여도 되지만, 한페이지에만 해당되는경우
 * 절대! 그렇게하면 안됨. 대부분의 CSS는 합쳐지는 Componet쪽에만 할당 할것! 
 */

ReactDOM.render(
  <React.StrictMode>
    {/*Search 컴포넌트 실행*/}
    <BrowserRouter>
    <Route path="/join" component={Join} />
    {/*<Route path="/login" component={Login} />*/}
    <Route path="/board" component={Board} />
    <Route path="/login" component={Login} />
    <Route path="/summoner:summoner" component={Contents} />
    </BrowserRouter>
    <Footer/>
    {/*소환사이름 넘기기 위해 react router dom 사용
     주소/: 사용하면 변수를 넘길수 있음
    실제로 바로넘어가는 형식이 아니라 path값으로 이동했을 때 component 실행*/}

  </React.StrictMode>,
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
