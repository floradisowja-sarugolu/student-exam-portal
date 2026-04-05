import React, { useEffect, useState } from "react";
import API from "../services/api";

function Exam() {
  const [questions, setQuestions] = useState([]);
  const [answers, setAnswers] = useState({});

  useEffect(() => {
    API.get("/questions")
      .then(res => setQuestions(res.data))
      .catch(err => console.error(err));
  }, []);

  const handleSelect = (qid, option) => {
    setAnswers({ ...answers, [qid]: option });
  };

  const handleSubmit = async () => {
  let score = 0;

  questions.forEach(q => {
    if (answers[q.id] === q.correctAnswer) {
      score++;
    }
  });

  try {
    await API.post("/submit", {
      studentName: JSON.parse(localStorage.getItem("student")).name,
      score: score
    });

    alert("Score: " + score);
  } catch (err) {
    console.error(err);
    alert("Error submitting result");
  }
};
  return (
    <div>
      <h2>Exam</h2>

      {questions.map(q => (
        <div key={q.id}>
          <p>{q.question}</p>

          <button onClick={() => handleSelect(q.id, "A")}>{q.optionA}</button>
          <button onClick={() => handleSelect(q.id, "B")}>{q.optionB}</button>
          <button onClick={() => handleSelect(q.id, "C")}>{q.optionC}</button>
          <button onClick={() => handleSelect(q.id, "D")}>{q.optionD}</button>
        </div>
      ))}

      <button onClick={handleSubmit}>Submit</button>
    </div>
  );
}

export default Exam;