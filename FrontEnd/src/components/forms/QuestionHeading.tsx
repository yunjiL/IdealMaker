
type QuestionHeadingProps = {
    questionText:string
}
const QuestionHeading = ({questionText}:QuestionHeadingProps) => {
    return (
        <p className="font-bold text-xl my-10 text-center">{questionText}</p>
    );
};

export default QuestionHeading;