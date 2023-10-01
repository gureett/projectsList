#include <cs50.h>
#include <ctype.h>
#include <math.h>
#include <stdio.h>
#include <string.h>

int count_letters(string text);
int count_words(string text);
int count_sentences(string text);

int main(void)
{
    string userInput = get_string("Text: ");

    int letters = count_letters(userInput);
    int words = count_words(userInput);
    int sentences = count_sentences(userInput);

    float L = ((float) letters / (float) words) * 100.0;
    float S = ((float) sentences / (float) words) * 100.0;
    int index = round(0.0588 * L - 0.296 * S - 15.8);

    if (index >= 16)
    {
        printf("Grade 16+\n");
    }
    else if (index < 1)
    {
        printf("Before Grade 1\n");
    }
    else
    {
        printf("Grade %i\n", index);
    }
}

int count_letters(string text)
{
    int sum = 0;
    int length = strlen(text);

    for (int i = 0; i < length; i++)
    {
        if (isalpha(text[i]))
        {
            sum++;
        }
    }
    return sum;
}

int count_words(string text)
{
    int sum = 0;
    int length = strlen(text);

    for (int i = 0; i < length; i++)
    {
        if (isblank(text[i]))
        {
            sum++;
        }
    }
    sum++;
    return sum;
}

int count_sentences(string text)
{
    int sum = 0;
    int length = strlen(text);

    for (int i = 0; i < length; i++)
    {
        if (text[i] == '!' || text[i] == '?' || text[i] == '.')
        {
            sum++;
        }
    }
    return sum;
}