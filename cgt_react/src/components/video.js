//import Video from "react-h5-video";
import React, {Component } from 'react';

class VideoTag extends Component{
    render(){

        return(
        <div>
            {/* <video class="joinvideo" autoPlay muted loop controls>
                <source src= {"./Videos/join_video_2.mp4"} type="video/mp4"/>
        </video> */}
            <video class="joinvideo2" autoPlay muted loop>
                <source src={"./Videos/join_video_3.mp4"} type="video/mp4"/>
            </video>
        </div>
        )
    }
    
};
export default VideoTag;