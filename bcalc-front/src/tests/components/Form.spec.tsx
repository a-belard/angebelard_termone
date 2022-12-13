import React from "react";
import { render, screen, waitFor } from "@testing-library/react";
import userEvent from "@testing-library/user-event";
import { CalcForm } from "../../components/CalcForm/Form";

test("rendering and submitting a basic Formik form", async () => {
  const handleSubmit = jest.fn();
  render(<CalcForm onSubmit={handleSubmit} />);
  const user = userEvent.setup();

  await user.type(screen.getByLabelText(/operand1/i), "10");
  await user.type(screen.getByLabelText(/operand2/i), "2");
  await user.type(screen.getByLabelText(/operation/i), "/");

  await user.click(screen.getByRole("button", { name: /submit/i }));

  await waitFor(() =>
    expect(handleSubmit).toHaveBeenCalledWith({
      operand1: 10,
      operand: 2,
      operation: "/",
    })
  );
});
