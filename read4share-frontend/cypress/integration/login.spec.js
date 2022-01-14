describe("Login tests", () => {
  beforeEach(() => {
    cy.visit("http://localhost:4200/login");
  });

  it("Should perform an incorrect login test", () => {
    cy.get('input[name="username"]').type("mario");
    cy.get('input[name="password"]').type("123");
    cy.get('button[name="login-btn"]').click();
    cy.get(".alert").should("have.text", " Invalid username or password! ");
  });
});
