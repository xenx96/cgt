import React, {Component } from 'react';
import Axios from "axios";
import  VideoTag  from "./video.js";
import Head from "./head.js"
import axios from 'axios';

class Join extends Component{
    state = { //~Check : 요청값 확인, 최종 3개 모두 확인완료시 Submit가능. ||
    IDNotice:'',
    IDCheck: false,
    emailNotice:'',
    EACheck : false,
    PW :'',
    PWCheck:false,
    PWNotice : '',
    emailTime : '',
    emailAuth : '',
    emailButton : "disable",
    emailnum : 0,
    emailAuthCheck :false,
    NNCheck : false,
    NNNotice :""};

  handleSubmit = async(e) => {
    if(this.state.IDCheck & this.state.EACheck & this.state.PWCheck &this.state.emailAuthCheck){
      const {ID, PW, SX, BT, NM, ADR, EA, MN} = e.target;
      const CA = new Date().getTime();
      try{

      var userfrm = {
        _id:ID.value ,
        PW :PW.value ,
        SX: SX.value ,
        BT : BT.value ,
        NM : NM.value,
        ADR : ADR.value ,
        EA : EA.value,
        MN : MN.value,
        CA
    }

      userfrm =  JSON.stringify(userfrm);
      let res = await Axios.post('/api/user',userfrm, {
          headers: { "Content-Type": `application/json`}
            });
        await alert(res.data?'회원가입이 되었습니다!': '다시 시도해 주세요!');
        window.location.href = (res.data?'../login':'../join');
      }catch(err){
        console.log(err);
      }
    }else{
      alert('입력하신 정보를 다시 확인해주세요.')
      e.preventDefault();
    }
    }
/*IDChecking Handler */
    handleIdCheck = async(e)=>{
      var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*/ //패턴
      if(e.target.value.length<6 | e.target.value.length>12 | !regExp.test(e.target.value)){
        this.setState({IDNotice : "아이디는 6~12자이상, 영어,숫자,_,-만 사용가능합니다. "});
      }
      else{

        try{
          let res = await Axios.get('/api/user?id='+e.target.value);
                this.setState({IDNotice :res.data? "사용 가능한 아이디입니다.":"이미 등록된 아이디입니다."});
                this.setState({IDCheck: res.data? true : false});
          console.log(res);
        }catch(err){
          console.error(err);
        }
      }

    };

/*Password Frame Check handler */
    handlePassword = (e)=>{
      this.setState({PW : e.target.value});
    };
    handlePasswordCheck = async(e)=>{
         await this.setState({PWCheck: this.state.PW===e.target.value ?true:false})
         await this.setState({PWNotice: this.state.PWCheck ? '비밀번호가 일치합니다.':'비밀번호가 일치하지 않습니다.'})
    };

/*Email Frame Check Handler */
    handleEmailFrame = async(e)=> {
      var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
      await this.setState({EACheck : regExp.test(e.target.value) ? true : false}); //이메일 유효 여부 확인
      await this.setState({emailNotice : this.state.EACheck?'사용 가능한 형식입니다.':'사용 불가능한 형식 입니다.'}); // 멘트출력
    };

    handleEmailSubmit = async(e)=>{
      res = await Axios.get("/api/user/email",e.target.EA.value)
      await this.setState({emailAuth : res.data});
      if (this.state.emailAuth==null){ 
        alert("사용중인 이메일입니다.");
        e.preventDefault();
      }else {
        alert("사용가능한 이메일입니다. 인증 번호를 입력하세요.")
        this.setstate({eamilButton : "enable"}) 
         e.preventDefault();
      }

    }

    handleEmailAuth= async(e)=>{
       
      if(e.target.value == this.state.emailAuth){
          alert("이메일 인증이 완료 되었습니다.")
          await this.setstate({emailAuthCheck : true, emailButton : "disable", emailnum : 0});
        }else{
          await this.setState({emailnum : 1++ });  
          if(emailnum >=3){
            alert("시도횟수가 초과되었습니다. 다시 인증 받으세요.");
            this.setstate({emailButton : "disable", emailAuth:"", emailnum : 0})
          }else{await alert(3-this.state.emailnum+"번 남았습니다. 다시 시도해주세요")}
            }
        
      }

      handleNickNameCheck = async(e)=>{
        res = await Axios.post("api/user/nickname="+e.target.NN.value)
        await res.data? this.setstate({NNcheck : true, NNNotice : "사용가능한 별명 입니다." }) : 
        this.setState({NNcheck :false, NNNotice : "사용불가능한 별명입니다." });
      }

    

    render(){

  return (

    <><Head/>
    <VideoTag/>

      <header>
        <a href="회원가입 링크"><p>회원가입</p></a>
      </header>

      <form >
        <div>
          <label>아이디</label><br />
          <input type="text" name="ID" onChange={this.handleIdCheck} minLength={6} maxLength={12} />
          <p>{this.state.IDNotice}</p>
        </div>
        <div>
          <label>비밀번호</label><br />
          <input type="password" name="PW" onChange={this.handlePassword} minLength={8} maxlength='17' placeholder="8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요" />
          <p>사용 불가</p>
        </div>
        <div>
          <label>비밀번호 재확인</label><br />
          <input type="password" name="PW2" onChange={this.handlePasswordCheck} />
          <p>{this.state.PWNotice}</p>
        </div>
        <div>
          <label>이름</label><br />
          <input type="text" name="NM" />
        </div>
        <div style={{display: "none"}} onchange ={this.handleNickNameCheck}> <label>별명{this.state.NNNotice}</label><br />
          <input type="text" name="NN" />
        </div>
        <div> <label>생년월일</label><br />
          <input type="date" name="BT" />
        </div>
        <div style={{display: "none"}}> <label>전화번호</label><br />
          <input type="text" name="MN" />
        </div>
        <div style={{display: "none"}}> <label>성별</label><br />
          <input type="text" name="SX" />
        </div>
        <div style={{display: "none"}}> <label>주소</label><br />
          <input type="text" name="ADR" />
        </div>
        <div>
          <label>본인 확인 이메일</label><br />
          <input type="email" name="EA" onChange={this.handleEmailFrame} />
          <input type="button" value="인증번호 받기" onSubmit ={this.handleEmailSubmit} /><br />
          <p>{this.state.emailNotice}</p>
          <input type="text" name ="EACheck"placeholder="인증번호 입력하세요" />
          <input type="button" value="인증번호 확인" onSubmit ={this.handleEmailAuth} disabled = {this.state.emailButton}/>
          <p>{this.state.emailTime} +"남았습니다."</p>
        </div>
        <input class="joinbutton" type="submit" value="가입하기" onSubmit={this.handleSubmit} />
      </form>
      </>




  )
    }
}

export default Join;
