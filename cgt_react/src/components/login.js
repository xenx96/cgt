import axios from 'axios';
import React from 'react';
class Login extends React.Component{
    state = {};
    handlelogin(){

    };

    render(){
        return(
            <form submit = {this.handlelogin}>
                    <div>아이디
                        <input type ='text' name = "id"/>
                        비밀번호
                        <input type ='password' name = 'pw'/>
                    </div>
            </form>
        )
    }
}