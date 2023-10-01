// Implements a dictionary's functionality

#include "dictionary.h"
#include <ctype.h>
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <strings.h>

// Represents a node in a hash table
typedef struct node
{
    char word[LENGTH + 1];
    struct node *next;
} node;

// Word Counter
int wordCount = 0;

// TODO: Choose number of buckets in hash table
const unsigned int N = 26;

// Hash table
node *table[N];

// Returns true if word is in dictionary, else false
bool check(const char *word)
{
    // TODO
    // hashing the word in the parameters
    int hash_value = hash(word);

    // create a cursor for the node and point it to the first node of the hash value
    node *c = table[hash_value];

    // while loop to go through the linked list of the bucket
    while (c != 0)
    {
        // compares the strings including capitalization
        if (strcasecmp(word, c->word) == 0)
        {
            // if they are the same return true
            return true;
        }
        // if not found then move the cursor to the next linked list
        c = c->next;
    }
    return false;
}

// Hashes word to a number
unsigned int hash(const char *word)
{
    // TODO: Improve this hash function
    // declare sum as integer and make it equal to 0
    int sum = 0;
    // for loop for hashing
    for (int i = 0; i < strlen(word); i++)
    {
        // adds the sum of all ascii values of the characters within this word
        sum = sum + tolower(word[i]);
    }
    // sum modulo N aka sum modulo 26, returns the remainder which is the bucket for that word
    return sum % N;
}

// Loads dictionary into memory, returning true if successful, else false
bool load(const char *dictionary)
{
    // TODO
    // Open the dictionary file
    FILE *dictionaryFile = fopen(dictionary, "r");

    // If file cannot be opened return false
    if (dictionaryFile == NULL)
    {
        return false;
    }

    // Create an array of characters of the max size a word can be
    char word[LENGTH + 1];

    // while loop scanning the file
    while (fscanf(dictionaryFile, "%s", word) != EOF)
    {
        // allocating memory to a node n with the size of a node
        node *n = malloc(sizeof(node));

        // if malloc fails return false
        if (n == NULL)
        {
            return false;
        }
        // copy the value from the node word to the char word
        strcpy(n->word, word);

        // finds the value of the hash using the hash function
        int hashValue = hash(word);

        // Sets the pointer of the node n to the current head of the table
        n->next = table[hashValue];

        // Set the new node to the head of the list
        table[hashValue] = n;

        // counts the number of words
        wordCount++;
    }
    // closes file
    fclose(dictionaryFile);
    return true;
}

// Returns number of words in dictionary if loaded, else 0 if not yet loaded
unsigned int size(void)
{
    // TODO
    return wordCount;
}

// Unloads dictionary from memory, returning true if successful, else false
bool unload(void)
{
    // TODO
    // for loop to go through each bucket
    for (int i = 0; i < N; i++)
    {
        // set the cursor to the start of the linked list of i
        node *c = table[i];

        // While loop for while cursor is not null, free memory
        while (c != NULL)
        {
            // create a temp node
            node *tmp = c;
            // set c to temp
            c = c->next;
            // free tmp
            free(tmp);
        }
    }
    return true;
}
