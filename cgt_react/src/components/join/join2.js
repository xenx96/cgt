import React, { useEffect, useRef, useState } from "react";
import Axios from "axios";
import VideoTag from "../video.js";
import Head from "../head.js";
import Joinstyle from "../../public/css/join.module.css";
import cn from "classnames";

/**
 *
 * Join Submit handler
 */

const Join = () => {
  const [IDCheck, setIDCheck] = useState(false);
  const [IDNotice, setIDNotice] = useState("");
  //PW
  const [PW, setPW] = useState("");
  const [PW2, setPW2] = useState("");
  const [PWCheck, setPWCheck] = useState(false);
  const [PWNotice, setPWNotice] = useState("");
  //EA
  const [emailNotice, setEmailNoitce] = useState("");
  const [EACheck, setEACheck] = useState(false);
  const [EA, setEA] = useState("");
  const [EAmem, setEAmem] = useState("");
  const [TimeString, setTimeString] = useState("");
  const [emailAuth, setEmailAuth] = useState("");
  const [emailButton, setEmailButton] = useState(true);
  const [emailnum, setEmailnum] = useState(0);
  const [emailAuthCheck, setEmailAuthCheck] = useState(false);
  //NicName
  const [NNCheck, setNNCheck] = useState(false);
  const [NNNotice, setNNNotice] = useState("");
  const [authInput, setAuthInput] = useState(null);
  const checkTime = useRef(null);

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (IDCheck & PWCheck & emailAuthCheck) {
      const { ID, PW, SX, BT, NM, ADR, EA, MN } = e.target;

      const CA = new Date().getTime();
      try {
        var userfrm = {
          _id: ID.value,
          PW: PW.value,
          SX: SX.value,
          BT: BT.value,
          NM: NM.value,
          ADR: ADR.value,
          EA: EA.value,
          MN: MN.value,
          CA,
        };
        userfrm = JSON.stringify(userfrm);
        let res = await Axios.post("/api/user", userfrm, {
          headers: { "Content-Type": `application/json` },
        });
        await alert(
          res.data ? "회원가입이 되었습니다!" : "다시 시도해 주세요!"
        );
        window.location.href = res.data ? "../login" : "../join";
      } catch (err) {
        console.log(err);
      }
    } else {
      alert("입력하신 정보를 다시 확인해주세요.");
      e.preventDefault(); // get방식으로 리디렉션하는것 방지
    }
  };

  /*IDChecking Handler */
  const handleIdCheck = async (e) => {
    var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*/; //패턴
    console.log(e.target.value);
    if (
      (e.target.value.length < 6) |
      (e.target.value.length > 12) |
      !regExp.test(e.target.value)
    ) {
      setIDNotice("아이디는 6~12자이상, 영어,숫자,_,-만 사용가능합니다. ");
    } else {
      try {
        let res = await Axios.get("/api/user?id=" + e.target.value);
        await setIDCheck(res.data ? true : false);
        console.log(res);
      } catch (err) {
        console.error(err);
      }
    }
  };
  useEffect(() => {
    setIDNotice(
      IDCheck ? "사용 가능한 아이디입니다." : "이미 등록된 아이디입니다."
    );
  }, [IDCheck]);

  /*Password Check handler */
  const handlePassword = (e) => {
    setPW(e.target.value);
  };
  const handlePasswordCheck = (e) => {
    setPW2(e.target.value);
  };
  useEffect(() => {
    setPWCheck(PW == PW2 ? true : false);
    setPWNotice(
      PW == PW2 ? "비밀번호가 일치합니다." : "비밀번호가 일치하지 않습니다."
    );
  }, [PW, PW2]);

  /*Email Handler */
  const handleEmailFrame = (e) => {
    setEAmem(e.target.value); // EACheck==true 이면 EA에 Email Set.
    var regExp =
      /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
    let regBool = regExp.test(e.target.value); //이메일 유효 여부 확인
    setEACheck(regBool); //유효여부 Save
  };
  useEffect(() => {
    setEA(EACheck ? EAmem : ""); // EACheck==true 이면 EA에 Email Set.
    setEmailNoitce(
      EACheck ? "사용 가능한 형식입니다." : "사용 불가능한 형식 입니다."
    );
  }, [EACheck, EAmem]);

  const handleEmailSubmit = async (e) => {
    if (EA === "" || !EACheck) {
      alert("사용가능한 이메일이 아닙니다.");
    } else {
      const EAfrm = await JSON.stringify({ EA });
      alert("이메일 전송중입니다. 잠시만 기다려주세요");
      let res = await Axios.post("/api/email", EAfrm, {
        headers: { "Content-Type": `application/json` },
      });
      if (res.data == "") {
        alert("사용중인 이메일입니다. 다시입력하세요.");
      } else {
        alert(" 인증 번호가 발송되었습니다. 인증번호를 입력하세요.");
        setEmailButton(false);
        setEmailAuth(res.data);
        setEmailnum(3);
        checkTime.current = 180;
      }
    }
  };

  const handleAuthInput = (e) => {
    setAuthInput(e.target.value);
  };
  const handleEmailAuth = async (e) => {
    if (authInput == emailAuth) {
      alert("이메일 인증이 완료 되었습니다.");
      setEmailAuthCheck(true);
      setEmailButton("disable");
      setEmailnum(0);
    } else {
      await setEmailnum((emailnum) => emailnum - 1);
      if (emailnum == -1) {
        alert("시도횟수가 초과되었습니다. 다시 인증 받으세요.");
        setEmailButton("none");
        setEmailAuth("");
        setEmailnum(0);
      } else {
        alert(3 - emailnum + "번 남았습니다. 다시 시도해주세요");
      }
    }
  };

  useEffect(() => {
    let Interval = setInterval(() => {
      if (checkTime.current > 0) {
        checkTime.current -= 1;
        let min = parseInt(checkTime.current / 60);
        let sec = checkTime.current % 60;
        setTimeString(min + "분 " + sec + "초 남았습니다.");
      } else if (emailnum > -1 && checkTime.current == 0) {
        clearInterval(Interval);
        alert("인증시간이 만료되었습니다! 다시 인증받아주세요!");
        setEmailButton("none");
        setEmailAuth("");
        setEmailnum(0);
        setTimeString("");
        checkTime.current = null;
      }
    }, 1000);
  }, []);

  /**
   * NickName Check.
   */
  const handleNickNameCheck = async (e) => {
    let res = await Axios.post("api/user/nickname=" + e.target.NN.value);
    await setNNCheck(res.data ? true : false);
    await setNNNotice(
      res.data ? "사용가능한 별명 입니다." : "사용불가능한 별명입니다."
    );
  };

  return (
    <>
      <Head />
      <VideoTag
        videoName="./Videos/join_video_3.mp4"
        videoClass={cn(Joinstyle.joinvideo2)}
      />
      <header>
        <a href="회원가입 링크">
          <p>회원가입</p>
        </a>
      </header>

      <form onSubmit={handleSubmit}>
        <div>
          <label>아이디</label>
          <br />
          <input
            type="text"
            name="ID"
            onChange={handleIdCheck}
            minLength={6}
            maxLength={12}
          />
          <p>{IDNotice}</p>
        </div>
        <div>
          <label>비밀번호</label>
          <br />
          <input
            type="password"
            name="PW"
            onChange={handlePassword}
            minLength={8}
            maxlength="17"
            placeholder="8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요"
          />
        </div>
        <div>
          <label>비밀번호 재확인</label>
          <br />
          <input type="password" name="PW2" onChange={handlePasswordCheck} />
          <p>{PWNotice}</p>
        </div>
        <div>
          <label>이름</label>
          <br />
          <input type="text" name="NM" />
        </div>
        <div style={{ display: "none" }} onChange={handleNickNameCheck}>
          {" "}
          <label>별명{NNNotice}</label>
          <br />
          <input type="text" name="NN" />
        </div>
        <div>
          {" "}
          <label>생년월일</label>
          <br />
          <input type="date" name="BT" />
        </div>
        <div style={{ display: "none" }}>
          {" "}
          <label>전화번호</label>
          <br />
          <input type="text" name="MN" />
        </div>
        <div style={{ display: "none" }}>
          {" "}
          <label>성별</label>
          <br />
          <input type="text" name="SX" />
        </div>
        <div style={{ display: "none" }}>
          {" "}
          <label>주소</label>
          <br />
          <input type="text" name="ADR" />
        </div>
        <div>
          <label>본인 확인 이메일</label>
          <br />
          <input type="email" name="EA" onChange={handleEmailFrame} />
          <input
            type="button"
            value="인증번호 전송"
            onClick={handleEmailSubmit}
          />
          <br />
          <p>{emailNotice}</p>
          <input
            type="text"
            name="EACheck"
            onChange={handleAuthInput}
            placeholder="인증번호 입력하세요"
          />
          <input
            type="button"
            value="인증번호 확인"
            onClick={handleEmailAuth}
            disabled={emailButton}
          />
          <p>{TimeString}</p>
        </div>
        <input class="joinbutton" type="submit" value="가입하기" />
      </form>
    </>
  );
};

export default Join;
