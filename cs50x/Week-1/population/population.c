#include <cs50.h>
#include <stdio.h>

int main(void)
{
    // Declaring Variables
    long startPop;
    long endPop;
    int yearsPop = 0;

    // TODO: Prompt for start size
    do
    {
        startPop = get_long("Start size? ");
    }
    while (startPop < 9);

    // TODO: Prompt for end size
    do
    {
        endPop = get_long("End size: ");
    }
    while (endPop < startPop);
    // TODO: Calculate number of years until we reach threshold
    while (startPop < endPop)
    {
        yearsPop++;
        startPop = (int) startPop + (int)(startPop / 3) - (int)(startPop / 4);
    }
    // TODO: Print number of years
    printf("Years: %i\n", yearsPop);
}
