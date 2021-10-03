import Axios from 'axios';
import React, {Component } from 'react';
class Login extends Component{
    state = {warningMessage : ""};
    handleLoginSubmit = async(e) =>{
        const {ID, PW} = e.target;
        const CA = new Date().getTime();
        try{

        var loginfrm = {
          _id: ID.value,
          PW: PW.value,
          CA
        }
        e.preventDefault();
        loginfrm =  JSON.stringify(loginfrm);
        alert(loginfrm);
        let res = await Axios.post('/api/login',loginfrm,
          {headers: { "Content-Type": `application/json`}}
        );
        alert(res.data?'로그인 되었습니다!': '다시 시도해 주세요!');
        res.data?localStorage.setItem('ACCESS_TOKEN',res.data):console.log('토큰저장실패');
        window.location.href = (res.data?'../main':'../login');
    }catch(err){
    console.log(err);
  }
}

    render(){
        return(
            <form onSubmit = {this.handleLoginSubmit}>
                    <div>아이디
                        <input type ='text' name = "ID"/>
                        비밀번호
                        <input type ='password' name = "PW"/>{this.state.warningMessage}
                    </div>
                    <input class="joinbutton" type="submit" value="로그인하기" />
            </form>
        )
    }
}
export default Login;
