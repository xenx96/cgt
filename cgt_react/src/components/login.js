import axios from 'axios';
import React from 'react';
class Login extends React.Component{
    state = {warningMessage : ""};
    handleLoginSubmit = async(e) =>{
        const {id, pw} = e.target ;

        const form = {ID : id.value,
                    PW : pw.value
        };
        let res = await axios.post("/api/login",form,
          {headers: { "Content-Type": `application/json`}}
        );
        await res.data?alert("로그인 되었습니다."):this.setState({
            warnigMessage : "ID 혹은 PW를 다시 확인해주세요."
        })
        res.data?localStorage.setItem('token',res.data):false;
        res.data?window.location.href("./main"):false;
    };

    render(){
        return(
            <form submit = {this.handleLoginSubmit}>
                    <div>아이디
                        <input type ='text' name = "id"/>
                        비밀번호
                        <input type ='password' name = 'pw'/>{this.state.warningMessage}
                    </div>
            </form>
        )
    }
}
