import Axios from "axios";
import React, { Component, useEffect, useState } from "react";
import VideoTag from "./video";
import Head from "./head";
import style from "../public/css/login.module.css";
import cn from "classnames";

const Login = () => {
  const [warningMessage, setWarningMessage] = useState("");

  const handleLoginSubmit = async (e) => {
    e.preventDefault();
    const { ID, PW } = e.target;
    const CA = new Date().getTime();
    try {
      var loginfrm = {
        _id: ID.value,
        PW: PW.value,
        CA,
      };
      e.preventDefault();
      loginfrm = JSON.stringify(loginfrm);
      alert(loginfrm);
      let res = await Axios.post("/api/login", loginfrm, {
        headers: { "Content-Type": `application/json` },
      });
      alert(res.data ? "로그인 되었습니다!" : "다시 시도해 주세요!");
      res.data
        ? localStorage.setItem("ACCESS_TOKEN", res.data)
        : console.log("토큰저장실패");
      window.location.href = res.data ? "../main" : "../login";
    } catch (err) {
      console.log(err);
    }
  };

  useEffect(() => {
    window.location.href = localStorage.getItem("ACCESS_TOKEN")
      ? "../main"
      : "../login";
  }, [localStorage.getItem("ACCESS_TOKEN")]);

  return (
    <>
      <Head />
      <body class={cn(style.body)}>
        <VideoTag
          videoName="./Videos/loginvideo.mp4"
          videoClass={cn(style.loginvd)}
        />
        <form onSubmit={this.handleLoginSubmit} class={cn(style.login)}>
          <h1 class={cn(style.logintitle)}>Log In</h1>
          <div class={cn(style.id)}>
            <label>ID :</label>
            <input type="text" name="ID" />
          </div>
          <div class={cn(style.pw)}>
            <label>PW :</label>
            <input type="password" name="PW" />
          </div>
          <div class={cn(style.autologin)}>
            <input type="radio" id="autologin2" />
            <label for="autologin2">자동 로그인</label>
          </div>
          <div class={cn(style.foundpw)}>
            <a href="비밀번호 찾기">PW를 잊으셨습니까?</a>
          </div>
          <div class={cn(style.loginbutton)}>
            <input type="submit" value="Log In" />
          </div>
          <div class={cn(style.joinbutton)}>
            <a href="/join">Join</a>
          </div>
        </form>
      </body>
    </>
  );
};

export default Login;
