library(tidyverse)

# Path to your single CSV file
file_path <- "C:/Users/sterr/IdeaProjects/subgrup-prop42.3/src/test/java/domain/algorithms/Unitarios/EstudioEstadísticoSA/Data/sa_estudio_resultados_4_23.csv"

# Read CSV, skip lines starting with "Seed"
data_raw <- read_csv(file_path, comment = "Seed")

# 1) Group by Temperature, Alpha, AND MinTemperature, summarizing by min(Cost)
df_min_cost <- data_raw %>%
  group_by(Temperature, Alpha, MinTemperature) %>%
  summarise(
    min_cost = min(Cost),
    .groups  = "drop"          # Ungroup automatically
  )

# 2) Sort by min_cost (ascending)
df_min_cost_sorted <- df_min_cost %>%
  arrange(min_cost)

# 3) Print out the top 5 rows (the best combos by minimum cost)
print(df_min_cost_sorted, n = 5)
