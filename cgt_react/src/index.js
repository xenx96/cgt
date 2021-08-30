import React from 'react';
import ReactDOM from 'react-dom';
import Header from './components/header';
import Footer from './components/footer';
import Contents from './components/contents';
import {BrowserRouter, Route} from 'react-router-dom';
import reportWebVitals from './reportWebVitals';

ReactDOM.render(
  <React.StrictMode>
    <Header/>
    {/*Search 컴포넌트 실행*/}
    <BrowserRouter>
      <Route path="/:summoner" component={Contents} />
    </BrowserRouter>
    {/*소환사이름 넘기기 위해 react router dom 사용
     주소/: 사용하면 변수를 넘길수 있음
    실제로 바로넘어가는 형식이 아니라 path값으로 이동했을 때 component 실행*/}
    <Footer />
  </React.StrictMode>,
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
