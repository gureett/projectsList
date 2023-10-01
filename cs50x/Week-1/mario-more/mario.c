#include <cs50.h>
#include <stdio.h>

int main(void)
{
    // Declaring Variables
    int height;

    // Do-While Loop to keep prompting the user until they provide a valid response
    do
    {
        height = get_int("Height: ");
    }
    while (height < 1 || height > 8);

    // Nested Loops to create the pyramids
    for (int i = 0; i < height; i++)
    {
        for (int j = 0; j < height - i - 1; j++)
        {
            printf(" ");
        }
        for (int k = 0; k <= i; k++)
        {
            printf("#");
        }
        printf("  ");
        for (int l = 0; l <= i; l++)
        {
            printf("#");
        }
        printf("\n");
    }
}