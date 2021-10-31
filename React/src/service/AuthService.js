import React from "react";
import decode from "jwt-decode";

export default class AuthService {
  getToken() {
    return localStorage.getItem("ACCESS_TOKEN");
  }

  isTokenExpired() {
    const token = this.getToken();
    try {
      const decoded = decode(token);
      if (decoded.exp < Date.now() / 1000) {
        return true;
      } else return false;
    } catch (err) {
      return false;
    }
  }

  isLoggedIn() {
    const token = this.getToken();
    return !!token && !this.isTokenExpired(token);
  }
  logout() {
    localStorage.removeItem("id_token");
  }
  getProfile() {
    return decode(this.getToken());
  }
}
