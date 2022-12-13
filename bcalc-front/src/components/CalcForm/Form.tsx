import { FC } from "react";
import { Formik, Field, Form } from "formik";

const sleep = (ms: number) => new Promise((r) => setTimeout(r, ms));

interface ISubmitValues {
  operand1: number;
  operand2: number;
  operation: string;
}

interface ICalcFormProps {
  onSubmit: (values: ISubmitValues) => void;
}

export const CalcForm: FC<ICalcFormProps> = ({ onSubmit }) => {
  const handleSubmit = async (values: ISubmitValues) => {
    await sleep(500);
    onSubmit(values);
  };

  return (
    <div>
      <h1>Simple Calc</h1>
      <Formik
        initialValues={
          {
            operand1: 0,
            operand2: 0,
            operation: "",
          } as ISubmitValues
        }
        onSubmit={handleSubmit}
      >
        <Form>
          <label htmlFor="operand1">Operand 1</label>
          <Field id="operand1" name="operand1" placeholder="0" />

          <label htmlFor="operand2">Operand 2</label>
          <Field id="operand2" name="operand2" placeholder="0" />

          <label htmlFor="operation">Operation</label>
          <Field
            id="operation"
            name="operation"
            placeholder="+"
            type="operation"
          />
          <button type="submit">Submit</button>
        </Form>
      </Formik>
    </div>
  );
};
