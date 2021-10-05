//import Video from "react-h5-video";
import React from 'react';

function VideoTag(props) {
    

        return(
        <div>
            {/* <video class="joinvideo" autoPlay muted loop controls>
                <source src= {"./Videos/join_video_2.mp4"} type="video/mp4"/>
        </video> */}
            <video class={props.videoClass} autoPlay muted loop>
                <source src={props.videoName} type="video/mp4"/>
            </video>
        </div>
        )
    }
    
;
export default VideoTag;