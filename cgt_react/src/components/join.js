import React, {Component } from 'react';
import Axios from "axios";
class Join extends React.Component{
    state = { //~Check : 요청값 확인, 최종 3개 모두 확인완료시 Submit가능. ||
    IDNotice:'',
    IDCheck: false,
    emailNotice:'',
    EACheck : false,
    PW :'',
    PWCheck:false,
    PWNotice : ''};

  handleSubmit = async(e) => {
    if(this.state.IDCheck & this.state.EACheck & this.state.PWCheck){
      const {ID, PW, SX, BT, NM, ADR, EA, MN} = e.target;
      const CA = new Date();
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

      userfrm = JSON.stringify(userfrm);
      alert(userfrm);
      //alert(userfrm);
        let res = await Axios.post('/api/user',userfrm, {
          headers: { "Content-Type": `application/json`}
            });
        alert(res.data?'회원가입이 되었습니다!': '다시 시도해 주세요!');
        Window.location.href(res.data?'redirect:/login':'redirect:/join');
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
      await this.setState({IDNotice : "아이디는 6~12자이상, 영어,숫자,_,-만 사용가능합니다. "});
      }
      else{

        try{
          let res = await Axios.get('/api/user?id='+e.target.value);
          await this.setState({IDNotice :res.data? "사용 가능한 아이디입니다.":"이미 등록된 아이디입니다."});
          await this.setState({IDCheck: res.data? true : false});
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
    handleEmailFrame =(e)=> {
      var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
      this.setState({EACheck : regExp.test(e.target.value) ? true : false}); //이메일 유효 여부 확인
      this.setState({emailNotice : this.state.EACheck?'사용 가능한 형식입니다.':'사용 불가능한 형식 입니다.'}); // 멘트출력
    };

    render(){
  return (
    <form onSubmit = {this.handleSubmit} method = "post">
        <div>
            아이디 <input type = "text"  name = "ID" onChange={this.handleIdCheck} minLength={6} maxLength = {12} /> <span>{this.state.IDNotice}</span>
        </div>
        <div>
            이름 <input type = "text" name = "NM"/>
        </div>
        <div>
            비밀번호 <input type = "password" name = "PW" minLength = {8} onChange ={this.handlePassword} placeholder = '8자리 이상 입력하세요.'/>
        </div>
        <div>
            비밀번호 확인 <input type = "password" name = "PW2" onChange={this.handlePasswordCheck} />{this.state.PWNotice}
        </div>
        <div>
            주소 <input type = "text" name = "ADR"/>
        </div>
        <div>
            이메일 <input type = "text" name = "EA" onChange = {this.handleEmailFrame}/> <span>{this.state.emailNotice}</span>
        </div>
        <div>
            전화 번호<input type = 'text' name = 'MN'/>
        </div>
        <div>
            성별<select name = 'SX'>
              <option value = '1' >남자 </option>
              <option value = '2' >여자 </option>
            </select>
        </div>
        <div>
            생년월일<input type = 'date' name = 'BT'/>
        </div>
        <div>
            Mobile-Number<input type = 'number' name = 'MN'/>
        </div>
     <button>회원 가입</button>
    </form>

  )
    }
}

export default Join;
