library(tidyverse)

# Path to your single CSV file
file_path <- "C:/Users/sterr/IdeaProjects/subgrup-prop42.3/src/test/java/domain/algorithms/Unitarios/EstudioEstadísticoSA/Data/sa_estudio_resultados_4_23.csv"

# Read CSV, skip lines starting with "Seed"
data_raw <- read_csv(file_path, comment = "Seed")

# Inspect
head(data_raw)
summary(data_raw)

# 1) Group by Temperature, Alpha, AND MinTemperature
df_summary <- data_raw %>%
  group_by(Temperature, Alpha, MinTemperature) %>%
  summarise(
    mean_cost   = mean(Cost),
    median_cost = median(Cost),
    count       = n(),         # optional: how many data points in each group
    .groups     = "drop"
  )

# 2) Arrange by mean_cost (ascending) to see the best combos first
df_summary_sorted <- df_summary %>%
  arrange(mean_cost)

# 3) Print out the top rows (the best combos)
options(pillar.sigfig = 8)
print(df_summary_sorted, n = 10)

