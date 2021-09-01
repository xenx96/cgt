import React from 'react';
import Axios from "axios";
const Join = () =>{

  const handleSubmit = async(event) => {
    try{  
    event.preventDefault(); 
    var userfrm = {
    ID : event.target.ID.value,
    PW : event.target.PW.value,
    ADR : event.target.ADR.value,
    EA :  event.target.EA.value,}

    await alert(userfrm.ID);
     
 
      await Axios.post('/api/join',userfrm);
      alert('Success.!')
    }catch(err){
      console.log(err);
    }
    }

  return (
    
 

    <form onSubmit = {handleSubmit} id ="userfrm">
        <div>
            ID <input type = "text" name = "ID"/>
        </div>
        <div>
            Name <input type = "text" name = "NM"/>
        </div>
        <div>
            PW1 <input type = "text" name = "PW"/>
        </div>
        <div>
            PW2 <input type = "text" name = "PW2"/>
        </div>
        <div>
            ADR <input type = "text" name = "ADR"/>
        </div>
        <div>
            EA <input type = "text" name = "EA"/>
        </div>
     <button>회원 가입</button>
    </form>

  )
}

export default Join;