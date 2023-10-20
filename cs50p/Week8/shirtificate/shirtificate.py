# Week 8 Project 3

# Importing fpdf
from fpdf import FPDF

# PDF Class which extends FPDF
class PDF(FPDF):
    # Defining the header
    def header(self):
        self.image("./shirtificate.png", 10, 70, 190)
        self.set_font("helvetica", "", 50)
        self.cell(0, 57, "CS50 Shirtificate", align="C")
        self.ln(20)


# Main
def main():
    name = input("Name: ")
    makeShirtPDF(name)

# Make Shirt PDF
def makeShirtPDF(s):
    # Making new pdf
    pdf = PDF()

    # Setting font and colour
    pdf.set_font("helvetica", size=30)
    pdf.set_text_color(255,255,255)

    # Adding page
    pdf.add_page(orientation="portrait", format="a4")

    # Cell
    pdf.cell(0, 213, f"{s} took CS50", align="C")

    # Output
    pdf.output("./shirtificate.pdf")


if __name__ == "__main__":
    main()