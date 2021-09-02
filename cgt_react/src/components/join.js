import React from 'react';
import Axios from "axios";
const Join = () =>{

  const handleSubmit = async(event) => {
    try{  
    event.preventDefault(); 
    var userfrm = {
    _id : event.target.ID.value,
    PW : event.target.PW.value,
    SX : event.target.SX.value,
    BT : event.target.BT.value,
    NM : event.target.NM.value,
    ADR : event.target.ADR.value,
    EA :  event.target.EA.value,
    MN : event.target.MN.value,
    CA : new Date(),

  }
    
    userfrm = JSON.stringify(userfrm);
    await alert(userfrm);
     
 
      await Axios.post('/api/join',userfrm,{
      headers: { "Content-Type": `application/json`}
      });
      alert('Success.!')
    }catch(err){
      console.log(err);
    }
    }

  return (
    
 

    <form onSubmit = {handleSubmit} id ="userfrm" method = "POST">
        <div>
            아이디 <input type = "text" name = "ID"/>
        </div>
        <div>
            이름 <input type = "text" name = "NM"/>
        </div>
        <div>
            비밀번호 <input type = "password" name = "PW"/>
        </div>
        <div>
            비밀번호 확인 <input type = "password" name = "PW2"/>
        </div>
        <div>
            주소 <input type = "text" name = "ADR"/>
        </div>
        <div>
            이메일 <input type = "text" name = "EA"/>
        </div>
        <div>
            전화 번호<input type = 'number' name = 'MN'/>
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
     <button>회원 가입</button>
    </form>

  )
}

export default Join;