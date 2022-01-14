describe("Read4Share Homepage", () => {
  beforeEach(() => {
    // Cypress starts out with a blank slate for each test
    // so we must tell it to visit our website with the `cy.visit()` command.
    // Since we want to visit the same URL at the start of all our tests,
    // we include it in our beforeEach function so that it runs before each test
    cy.visit("http://localhost:4200/home");
  });

  it("displays the four carousels by default", () => {
    cy.contains("Recently added").should("have.length", 1);
    cy.contains("Best rated").should("have.length", 1);
    cy.contains("Free delivery").should("have.length", 1);
    cy.contains("As new").should("have.length", 1);
  });

  it("carousel should have at least four elements", () => {
    cy.contains("Recently added")
      .parent()
      .within(($carousel) => {
        cy.get(".adv-overview").should("have.length.at.least", 4);
      });
  });
});

/*
cy.get('form').within(($form) => {
// cy.get() will only search for elements within form,
// not within the entire document
cy.get('input[name="username"]').type('john')
cy.get('input[name="password"]').type('password')
cy.root().submit()
})
*/
