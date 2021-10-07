import React, { useEffect, useState } from 'react';
import Axios from "axios";
import  VideoTag  from "../video.js";
import Head from "../head.js"
import Joinstyle from "../../public/css/join.module.css";
import cn from "classnames";

//class Join extends React.Component{
  //const {IDNotice,PW,PWNotice,emailNotice,EA,TimeString,emailAuth,NNNotice}=useStates('')
  //const {IDCheck,EACheck,PWCheck,emailAuthCheck,NNCheck} =useStates(false)
  //setIDCheck()


  

  /**
   * 
   * Join Submit handler 
   */
 

    
const Join = ()=>{
  let [States, setStates] = useState({ 
    IDNotice:'',
    IDCheck: false,
    emailNotice:'',
    EACheck : false,
    PW :'',
    PWCheck:false,
    PWNotice : '',
    EA : '',
    emailTime : 0,
    TimeString : "",
    emailAuth : '',
    emailButton : true,
    emailnum : 0,
    emailAuthCheck :false,
    NNCheck : false,
    NNNotice :"",
    authInput : null});


    const handleSubmit = async(e) => {
    
    
      e.preventDefault();
      if(States.IDCheck & States.EACheck & States.PWCheck &States.emailAuthCheck){
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
        e.preventDefault(); // get방식으로 리디렉션하는것 방지
      }
    }
  
  /*IDChecking Handler */
    const  handleIdCheck = async(e)=>{
        var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*/ //패턴
        console.log(e.target.value);
        if(e.target.value.length<6 | e.target.value.length>12 | !regExp.test(e.target.value)){
          setStates({IDNotice : "아이디는 6~12자이상, 영어,숫자,_,-만 사용가능합니다. "});
        }
        else{
  
          try{
            let res = await Axios.get('/api/user?id='+e.target.value);
                 await setStates({IDNotice :res.data? "사용 가능한 아이디입니다.":"이미 등록된 아이디입니다."});
                 await setStates({IDCheck: res.data? true : false});
            console.log(res);
          }catch(err){
            console.error(err);
          }
        }
  
      };
  
  /*Password Check handler */
    const handlePassword = (e)=>{
        setStates({PW : e.target.value});
      };
    const handlePasswordCheck = async(e)=>{
           await setStates({PWCheck: States.PW===e.target.value ?true:false})
           await setStates({PWNotice: States.PWCheck ? '비밀번호가 일치합니다.':'비밀번호가 일치하지 않습니다.'})
      };
  
  /*Email Handler */
    const  handleEmailFrame = async(e)=> {  
      var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
      let regBool =  regExp.test(e.target.value);
      await setStates({EACheck : regBool}); //이메일 유효 여부 확인
      await setStates({emailNotice : regBool?'사용 가능한 형식입니다.':'사용 불가능한 형식 입니다.'});
      await setStates({EA : States.EACheck? e.target.value:""}) // 멘트출력
      alert(States.EACheck);


      };
  
    const  handleEmailSubmit = async(e)=>{
        e.preventDefault();
        alert(States.EA);
        if(States.EA === ""){
          alert("사용가능한 이메일이 아닙니다.");
        }else{
          const EA = await JSON.stringify({EA : States.EA});
          let res = await Axios.post("/api/email",EA, {
            headers: { "Content-Type": `application/json`}
          });
  
          if (res.data==""){ 
            alert("사용중인 이메일입니다. 다시입력하세요.");
          }else {
            alert(" 인증 번호가 발송되었습니다. 인증번호를 입력하세요.")
            setStates({emailButton : false,emailAuth : res.data,emailTime : 180});
  
            
          }
        }
      }
      
    const handleAuthInput = (e)=>{
        setStates({authInput : e.target.value})
      }
    const handleEmailAuth= async(e)=>{
        if(States.authInput == States.emailAuth){
            alert("이메일 인증이 완료 되었습니다.")
            await setStates({emailAuthCheck : true, emailButton : "disable", emailnum : 0});
          }else{
            await setStates({emailnum : States.emailnum+1 });  
            if(States.emailnum >=3){
              alert("시도횟수가 초과되었습니다. 다시 인증 받으세요.");
              setStates({emailButton : "none", emailAuth:"", emailnum : 0, emailTime : ""});
            }else{
              await alert(3-States.emailnum+"번 남았습니다. 다시 시도해주세요");
            }
          }
          
        }
    const  emailTimeCheck = async()=>{
      if(States.emailTime>0){
          let min = parseInt(States.emailTime/60);
          let sec = States.emailTime%60;
          setStates({TimeString : min+"분 "+sec+"초 남았습니다.", emailtime : States.emailTime-1});
          if(States.emailTime==0){
            setStates({emailButton : "none", emailAuth:"", emailnum : 0, emailTime : ""});
            alert('인증시간이 만료되었습니다!');
          }
    }
  };
    useEffect(()=>{
      let T = setInterval(emailTimeCheck,1000)
      return ()=>clearInterval(T);
    });
        
  /**
   * NickName Check. 
   */
    const  handleNickNameCheck = async(e)=>{
          let res = await Axios.post("api/user/nickname="+e.target.NN.value)
          await res.data? setStates({NNcheck : true, NNNotice : "사용가능한 별명 입니다." }) : 
          setStates({NNcheck :false, NNNotice : "사용불가능한 별명입니다." });
        }

  return (

    <><Head/>
    <VideoTag videoName ="./Videos/join_video_3.mp4" videoClass={cn(Joinstyle.joinvideo2)}/>
      <header>
        <a href="회원가입 링크"><p>회원가입</p></a>
      </header>

      <form onSubmit={handleSubmit} >
        <div>
          <label>아이디</label><br />
          <input type="text" name="ID" onChange={handleIdCheck} minLength={6} maxLength={12} />
          <p>{States.IDNotice}</p>
        </div>
        <div>
          <label>비밀번호</label><br />
          <input type="password" name="PW" onChange={handlePassword} minLength={8} maxlength='17' placeholder="8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요" />
        </div>
        <div>
          <label>비밀번호 재확인</label><br />
          <input type="password" name="PW2" onChange={handlePasswordCheck} />
          <p>{States.PWNotice}</p>
        </div>
        <div>
          <label>이름</label><br />
          <input type="text" name="NM" />
        </div>
        <div style={{display: "none"}} onchange ={handleNickNameCheck}> <label>별명{States.NNNotice}</label><br />
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
          <input type="email" name="EA" onChange={handleEmailFrame} />
          <input type="button" value = "인증번호 전송" onClick ={handleEmailSubmit} /><br />
          <p>{States.emailNotice}</p>
          <input type="text"  name ="EACheck" onChange = {handleAuthInput} placeholder="인증번호 입력하세요" />
          <input type="button" value="인증번호 확인" onClick ={handleEmailAuth} disabled = {States.emailButton}/>
          <p>{States.TimeString}</p>
        </div>
        <input class="joinbutton" type="submit" value="가입하기" />
      </form>
      </>




  )
    }


export default Join;