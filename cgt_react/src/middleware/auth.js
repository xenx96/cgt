import decode from 'jwt-decode';

JWTDecoded = async(token)=>{
    return decode(token,{scret});

}