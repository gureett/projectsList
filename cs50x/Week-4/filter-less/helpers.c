#include "helpers.h"
#include <math.h>

// Convert image to grayscale
void grayscale(int height, int width, RGBTRIPLE image[height][width])
{
    float avg = 0;
    for (int i = 0; i < height; i++)
    {
        for (int j = 0; j < width; j++)
        {
            avg = image[i][j].rgbtBlue + image[i][j].rgbtRed + image[i][j].rgbtGreen;
            avg = round(avg / 3.0);
            image[i][j].rgbtBlue = avg;
            image[i][j].rgbtRed = avg;
            image[i][j].rgbtGreen = avg;
        }
    }
    return;
}

// Convert image to sepia
void sepia(int height, int width, RGBTRIPLE image[height][width])
{
    float sepiaRed = 0;
    float sepiaBlue = 0;
    float sepiaGreen = 0;

    for (int i = 0; i < height; i++)
    {
        for (int j = 0; j < width; j++)
        {
            sepiaRed = round((0.393 * image[i][j].rgbtRed) + (0.769 * image[i][j].rgbtGreen) + (0.189 * image[i][j].rgbtBlue));
            sepiaGreen = round((0.349 * image[i][j].rgbtRed) + (0.686 * image[i][j].rgbtGreen) + (0.168 * image[i][j].rgbtBlue));
            sepiaBlue = round((0.272 * image[i][j].rgbtRed) + (0.534 * image[i][j].rgbtGreen) + (0.131 * image[i][j].rgbtBlue));
            if (sepiaRed > 255)
            {
                image[i][j].rgbtRed = 255;
            }
            else
            {
                image[i][j].rgbtRed = sepiaRed;
            }
            if (sepiaGreen > 255)
            {
                image[i][j].rgbtGreen = 255;
            }
            else
            {
                image[i][j].rgbtGreen = sepiaGreen;
            }
            if (sepiaBlue > 255)
            {
                image[i][j].rgbtBlue = 255;
            }
            else
            {
                image[i][j].rgbtBlue = sepiaBlue;
            }
        }
    }
    return;
}

// Reflect image horizontally
void reflect(int height, int width, RGBTRIPLE image[height][width])
{
    // use height constant, but change the pixel at i = 0; i++, with the pixel at ctr = height, ctr--;
    // If width is odd then dont swap middle value, if width is even then swap middle values
    for (int i = 0; i < height; i++)
    {
        for (int j = 0; j < width / 2; j++)
        {
            RGBTRIPLE temp = image[i][j];
            image[i][j] = image[i][width - j - 1];
            image[i][width - j - 1] = temp;
        }
    }
    return;
}

// Blur image
void blur(int height, int width, RGBTRIPLE image[height][width])
{
    RGBTRIPLE copy[height][width];
    const int corner = 4;
    const int edge = 6;
    const int rest = 9;

    for (int i = 0; i < height; i++)
    {
        for (int j = 0; j < height; j++)
        {
            copy[i][j] = image[i][j];
        }
    }

    for (int i = 0; i < height; i++)
    {
        for (int j = 0; j < width; j++)
        {
            if (j == 0 && i == 0)
            {
                float avgRed = copy[i][j].rgbtRed + copy[i + 1][j].rgbtRed + copy[i][j + 1].rgbtRed + copy[i + 1][j + 1].rgbtRed;
                avgRed = round(avgRed / corner);
                float avgBlue = copy[i][j].rgbtBlue + copy[i + 1][j].rgbtBlue + copy[i][j + 1].rgbtBlue + copy[i + 1][j + 1].rgbtBlue;
                avgBlue = round(avgBlue / corner);
                float avgGreen = copy[i][j].rgbtGreen + copy[i + 1][j].rgbtGreen + copy[i][j + 1].rgbtGreen + copy[i + 1][j + 1].rgbtGreen;
                avgGreen = round(avgGreen / corner);
                image[i][j].rgbtRed = avgRed;
                image[i][j].rgbtBlue = avgBlue;
                image[i][j].rgbtGreen = avgGreen;
            }
            else if (j == width - 1 && i == 0)
            {
                float avgRed = copy[i][j].rgbtRed + copy[i + 1][j].rgbtRed + copy[i][j - 1].rgbtRed + copy[i + 1][j - 1].rgbtRed;
                avgRed = round(avgRed / corner);
                float avgBlue = copy[i][j].rgbtBlue + copy[i + 1][j].rgbtBlue + copy[i][j - 1].rgbtBlue + copy[i + 1][j - 1].rgbtBlue;
                avgBlue = round(avgBlue / corner);
                float avgGreen = copy[i][j].rgbtGreen + copy[i + 1][j].rgbtGreen + copy[i][j - 1].rgbtGreen + copy[i + 1][j - 1].rgbtGreen;
                avgGreen = round(avgGreen / corner);
                image[i][j].rgbtRed = avgRed;
                image[i][j].rgbtBlue = avgBlue;
                image[i][j].rgbtGreen = avgGreen;
            }
            else if (j == 0 && i == height - 1)
            {
                float avgRed = copy[i][j].rgbtRed + copy[i - 1][j].rgbtRed + copy[i][j + 1].rgbtRed + copy[i - 1][j + 1].rgbtRed;
                avgRed = round(avgRed / corner);
                float avgBlue = copy[i][j].rgbtBlue + copy[i - 1][j].rgbtBlue + copy[i][j + 1].rgbtBlue + copy[i - 1][j + 1].rgbtBlue;
                avgBlue = round(avgBlue / corner);
                float avgGreen = copy[i][j].rgbtGreen + copy[i - 1][j].rgbtGreen + copy[i][j + 1].rgbtGreen + copy[i - 1][j + 1].rgbtGreen;
                avgGreen = round(avgGreen / corner);
                image[i][j].rgbtRed = avgRed;
                image[i][j].rgbtBlue = avgBlue;
                image[i][j].rgbtGreen = avgGreen;
            }
            else if (j == width - 1 && i == height - 1)
            {
                float avgRed = copy[i][j].rgbtRed + copy[i - 1][j].rgbtRed + copy[i][j - 1].rgbtRed + copy[i - 1][j - 1].rgbtRed;
                avgRed = round(avgRed / corner);
                float avgBlue = copy[i][j].rgbtBlue + copy[i - 1][j].rgbtBlue + copy[i][j - 1].rgbtBlue + copy[i - 1][j - 1].rgbtBlue;
                avgBlue = round(avgBlue / corner);
                float avgGreen = copy[i][j].rgbtGreen + copy[i - 1][j].rgbtGreen + copy[i][j - 1].rgbtGreen + copy[i - 1][j - 1].rgbtGreen;
                avgGreen = round(avgGreen / corner);
                image[i][j].rgbtRed = avgRed;
                image[i][j].rgbtBlue = avgBlue;
                image[i][j].rgbtGreen = avgGreen;
            }
            else if (j == 0)
            {
                float avgRed = copy[i][j].rgbtRed + copy[i + 1][j].rgbtRed + copy[i][j + 1].rgbtRed + copy[i + 1][j + 1].rgbtRed + copy[i - 1][j].rgbtRed + copy[i - 1][j + 1].rgbtRed;
                avgRed = round(avgRed / edge);
                float avgBlue = copy[i][j].rgbtBlue + copy[i + 1][j].rgbtBlue + copy[i][j + 1].rgbtBlue + copy[i + 1][j + 1].rgbtBlue + copy[i - 1][j].rgbtBlue + copy[i - 1][j + 1].rgbtBlue;
                avgBlue = round(avgBlue / edge);
                float avgGreen = copy[i][j].rgbtGreen + copy[i + 1][j].rgbtGreen + copy[i][j + 1].rgbtGreen + copy[i + 1][j + 1].rgbtGreen + copy[i - 1][j].rgbtGreen + copy[i - 1][j + 1].rgbtGreen;
                avgGreen = round(avgGreen / edge);
                image[i][j].rgbtRed = avgRed;
                image[i][j].rgbtBlue = avgBlue;
                image[i][j].rgbtGreen = avgGreen;
            }
            else if (j == width - 1)
            {
                float avgRed = copy[i][j].rgbtRed + copy[i + 1][j].rgbtRed + copy[i][j - 1].rgbtRed + copy[i + 1][j - 1].rgbtRed + copy[i - 1][j].rgbtRed + copy[i - 1][j - 1].rgbtRed;
                avgRed = round(avgRed / edge);
                float avgBlue = copy[i][j].rgbtBlue + copy[i + 1][j].rgbtBlue + copy[i][j - 1].rgbtBlue + copy[i + 1][j - 1].rgbtBlue + copy[i - 1][j].rgbtBlue + copy[i - 1][j - 1].rgbtBlue;
                avgBlue = round(avgBlue / edge);
                float avgGreen = copy[i][j].rgbtGreen + copy[i + 1][j].rgbtGreen + copy[i][j - 1].rgbtGreen + copy[i + 1][j - 1].rgbtGreen + copy[i - 1][j].rgbtGreen + copy[i - 1][j - 1].rgbtGreen;
                avgGreen = round(avgGreen / edge);
                image[i][j].rgbtRed = avgRed;
                image[i][j].rgbtBlue = avgBlue;
                image[i][j].rgbtGreen = avgGreen;
            }
            else if (i == 0)
            {
                float avgRed = copy[i][j].rgbtRed + copy[i][j - 1].rgbtRed + copy[i][j + 1].rgbtRed + copy[i + 1][j].rgbtRed + copy[i + 1][j - 1].rgbtRed + copy[i + 1][j + 1].rgbtRed;
                avgRed = round(avgRed / edge);
                float avgBlue = copy[i][j].rgbtBlue + copy[i][j - 1].rgbtBlue + copy[i][j + 1].rgbtBlue + copy[i + 1][j].rgbtBlue + copy[i + 1][j - 1].rgbtBlue + copy[i + 1][j + 1].rgbtBlue;
                avgBlue = round(avgBlue / edge);
                float avgGreen = copy[i][j].rgbtGreen + copy[i][j - 1].rgbtGreen + copy[i][j + 1].rgbtGreen + copy[i + 1][j].rgbtGreen + copy[i + 1][j - 1].rgbtGreen + copy[i + 1][j + 1].rgbtGreen;
                avgGreen = round(avgGreen / edge);
                image[i][j].rgbtRed = avgRed;
                image[i][j].rgbtBlue = avgBlue;
                image[i][j].rgbtGreen = avgGreen;
            }
            else if (i == height - 1)
            {
                float avgRed = copy[i][j].rgbtRed + copy[i][j - 1].rgbtRed + copy[i][j + 1].rgbtRed + copy[i - 1][j].rgbtRed + copy[i - 1][j - 1].rgbtRed + copy[i - 1][j + 1].rgbtRed;
                avgRed = round(avgRed / edge);
                float avgBlue = copy[i][j].rgbtBlue + copy[i][j - 1].rgbtBlue + copy[i][j + 1].rgbtBlue + copy[i - 1][j].rgbtBlue + copy[i - 1][j - 1].rgbtBlue + copy[i - 1][j + 1].rgbtBlue;
                avgBlue = round(avgBlue / edge);
                float avgGreen = copy[i][j].rgbtGreen + copy[i][j - 1].rgbtGreen + copy[i][j + 1].rgbtGreen + copy[i - 1][j].rgbtGreen + copy[i - 1][j - 1].rgbtGreen + copy[i - 1][j + 1].rgbtGreen;
                avgGreen = round(avgGreen / edge);
                image[i][j].rgbtRed = avgRed;
                image[i][j].rgbtBlue = avgBlue;
                image[i][j].rgbtGreen = avgGreen;
            }
            else
            {
                float avgRed = copy[i - 1][j - 1].rgbtRed + copy[i - 1][j].rgbtRed + copy[i - 1][j + 1].rgbtRed + copy[i][j - 1].rgbtRed + copy[i][j].rgbtRed + copy[i][j + 1].rgbtRed + copy[i + 1][j - 1].rgbtRed + copy[i + 1][j].rgbtRed + copy[i + 1][j + 1].rgbtRed;
                avgRed = round(avgRed / rest);
                float avgBlue = copy[i - 1][j - 1].rgbtBlue + copy[i - 1][j].rgbtBlue + copy[i - 1][j + 1].rgbtBlue + copy[i][j - 1].rgbtBlue + copy[i][j].rgbtBlue + copy[i][j + 1].rgbtBlue + copy[i + 1][j - 1].rgbtBlue + copy[i + 1][j].rgbtBlue + copy[i + 1][j + 1].rgbtBlue;
                avgBlue = round(avgBlue / rest);
                float avgGreen = copy[i - 1][j - 1].rgbtGreen + copy[i - 1][j].rgbtGreen + copy[i - 1][j + 1].rgbtGreen + copy[i][j - 1].rgbtGreen + copy[i][j].rgbtGreen + copy[i][j + 1].rgbtGreen + copy[i + 1][j - 1].rgbtGreen + copy[i + 1][j].rgbtGreen + copy[i + 1][j + 1].rgbtGreen;
                avgGreen = round(avgGreen / rest);
                image[i][j].rgbtRed = avgRed;
                image[i][j].rgbtBlue = avgBlue;
                image[i][j].rgbtGreen = avgGreen;
            }
        }
    }
    return;
}
