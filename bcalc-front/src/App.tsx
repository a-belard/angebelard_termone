import React from "react";
import "./App.css";
import { CalcForm } from "./components/CalcForm/Form";

function App() {
  return (
    <div className="App">
      <CalcForm onSubmit={() => {}} />
    </div>
  );
}

export default App;
