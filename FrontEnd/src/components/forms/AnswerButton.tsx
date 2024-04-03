import React from "react";
import {Button} from "flowbite-react";

type AnswerButtonProps = {
    questionText: string
    onClick: React.MouseEventHandler
    style: string
}
export default function AnswerButton(props: AnswerButtonProps) {
    const {questionText, onClick, style} = props;
    return (
        <Button onClick={onClick} className={style}>{questionText}</Button>
    );
}
