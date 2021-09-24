import React,{Component} from "react";
import css from "../public/css/join_test.css";
import MetaTags from 'react-meta-tags';

class Head extends Component {
    render(){
        return(
            <head>
                <MetaTags>
            <meta charset="UTF-8"/>
            <meta http-Equiv="X-UA-Compatible" content="IE=edge"/>
            <meta name="ViewPort" content="width=device-width, initial-scale=1.0"/>
            <title>Join</title>
            <link rel="stylesheet" href={css}/>
            </MetaTags>
            </head>
        )
    }
}

export default Head;