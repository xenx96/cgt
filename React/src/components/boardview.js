import React, { Component } from "react";
import Axios from "axios";
import AuthService from "../service/AuthService";
import "../boardview.css";
class Boardview extends React.Component {
  constructor(props) {
    super(props);
    this.state = {};
    this.Auth = new AuthService();
  }
  render() {
    return (
      <div class="body">
        <content class="boardbody">
          <ul>
            <a href="#">
              <li class="boardinfo">
                <div class="boardid">1</div>
                <div class="boardtitle">게시물제목</div>
                <div class="boardwriter">작성자</div>
              </li>
            </a>
          </ul>
        </content>
      </div>
    );
  }
}

export default Boardview;
