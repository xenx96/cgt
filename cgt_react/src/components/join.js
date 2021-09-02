import React from 'react';
import Axios from "axios";
const Join = () =>{

  const handleSubmit = async(event) => {
    try{  
    event.preventDefault(); 
    var userfrm = {
    ID : event.target.ID.value,
    PW : event.target.PW.value,
    NM : event.target.NM.value,
    ADR : event.target.ADR.value,
    EA :  event.target.EA.value,
    MN : event.target.MN.value}
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
            ID <input type = "text" name = "ID"/>
        </div>
        <div>
            Name <input type = "text" name = "NM"/>
        </div>
        <div>
            PW1 <input type = "password" name = "PW"/>
        </div>
        <div>
            PW2 <input type = "password" name = "PW2"/>
        </div>
        <div>
            ADR <input type = "text" name = "ADR"/>
        </div>
        <div>
            EA <input type = "text" name = "EA"/>
        </div>
        <div>
            Mobile-Number<input type = 'number' name = 'MN'/>
        </div>
     <button>회원 가입</button>
    </form>

  )
}

export default Join;