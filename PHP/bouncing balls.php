<?php

function bouncingBall($h, $bounce, $window) {
    $ballseen = 1;
    if ($window >= $h) {
        return -1;
    }
    else if ($bounce <= 0 || $bounce >= 1) {
        return -1;
    }
    else if ($h <= 0) {
        return -1;
    }
    $i = 0;
    while(true){
        $h *= $bounce;
        if ($h > $window)
        {
            $ballseen += 2;
        }
        else {
            return $ballseen;
        }
        $i++;
    }
    return $ballseen;
}

echo bouncingBall(80, 0.15, 12);



