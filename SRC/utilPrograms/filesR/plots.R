library(tidyverse)

# Path to your single CSV file
file_path <- "C:/Users/sterr/IdeaProjects/subgrup-prop42.3/src/test/java/domain/algorithms/Unitarios/EstudioEstadísticoSA/Data/sa_estudio_resultados_4_13.csv"

# Use read_csv with comment = "Seed" to skip lines that start with "Seed"
data_raw <- read_csv(file_path, comment = "Seed")

# Check the first few rows to make sure it looks okay
head(data_raw)
summary(data_raw)


# Convert Alpha to factor
data_raw$Alpha <- as.factor(data_raw$Alpha)

ggplot(data_raw, aes(x = Temperature, y = Cost, fill = Alpha)) +
  geom_boxplot(position = "dodge") +
  labs(title = "Cost by Temperature and Alpha",
       x = "Temperature",
       y = "Cost",
       fill = "Alpha") +
  theme_minimal()

