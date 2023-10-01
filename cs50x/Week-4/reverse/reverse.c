#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>

#include "wav.h"

int check_format(WAVHEADER header);
int get_block_size(WAVHEADER header);

int main(int argc, char *argv[])
{
    // Declaring WAVHEADER
    WAVHEADER fileDetails;
    const int arraySize = 4;
    const int headerSize = 44;
    int ctr = 0;
    // Ensure proper usage
    // TODO #1
    if (argc != 3)
    {
        printf("Usage: ./reverse input.wav output.wav\n");
        return 1;
    }

    // Open input file for reading
    // TODO #2
    FILE *input = fopen(argv[1], "r");
    if (input == NULL)
    {
        return 1;
    }

    // Read header
    // TODO #3
    fread(&fileDetails, sizeof(WAVHEADER), 1, input);

    // Use check_format to ensure WAV format
    // TODO #4
    int check = check_format(fileDetails);

    // Open output file for writing
    // TODO #5
    FILE *output = fopen(argv[2], "w");

    // Write header to file
    // TODO #6
    fwrite(&fileDetails, sizeof(WAVHEADER), 1, output);

    // Use get_block_size to calculate size of block
    // TODO #7
    int blockSize = get_block_size(fileDetails);

    // Write reversed audio to file
    // TODO #8
    BYTE buffer[blockSize];
    for (fseek(input, 0 - blockSize, SEEK_END); ftell(input) > sizeof(fileDetails)- blockSize; fseek(input, 0 - (blockSize * 2), SEEK_CUR))
    {
        fread(&buffer, blockSize, 1, input);
        fwrite(&buffer, blockSize, 1, output);
    }

    fclose(output);
    fclose(input);
    return 0;
}

int check_format(WAVHEADER header)
{
    // TODO #4
    // Hex for the bytes that should be in File Format
    int wav[] = {0x57, 0x41, 0x56, 0x45};
    int i;
    for (i = 0; i < 4; i++)
    {
        if (header.format[i] != wav[i])
        {
            printf("Not a valid WAV file!\n");
            return 1;
        }
    }
    return 0;
}

int get_block_size(WAVHEADER header)
{
    // TODO #7
    int value = header.bitsPerSample / 8;
    value = value * header.numChannels;
    return value;
}