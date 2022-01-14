describe("Registration tests", () => {
  beforeEach(() => {
    cy.visit("http://localhost:4200/register");
  });

  it("Should not allow to register a user with the same name", () => {
    cy.get('input[name="username"]').type("mario");
    cy.get('input[name="email"]').type("mario@gmail.com");
    cy.get('input[name="password"]').type("123456");
    cy.get('input[name="passwordCheck"]').type("123456");
    cy.get('button[name="register-btn"]').click();
    cy.get(".alert").should(
      "contain",
      "Username mario already exists! Choose another one"
    );
  });
});
